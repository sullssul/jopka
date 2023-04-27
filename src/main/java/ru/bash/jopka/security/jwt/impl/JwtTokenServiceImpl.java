package ru.bash.jopka.security.jwt.impl;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.usecase.GetUserByEmailQuery;
import ru.bash.jopka.business.user.usecase.GetUserQuery;
import ru.bash.jopka.exception.APIException;
import ru.bash.jopka.security.jwt.JwtTokenService;
import ru.bash.jopka.security.jwt.model.JwtToken;
import ru.bash.jopka.security.jwt.usecase.*;

import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenServiceImpl implements JwtTokenService {
    private static final String TOKEN_TYPE = "Bearer";
    @Value("${app-jwt-expiration-milliseconds}")
    private Long tokenExpirationTime;

    @Value("${app.jwt-secret}")
    private String jwtSecret;

    private final CreateTokenCommand createTokenCommand;
    private final GetJwtByTokenQuery getJwtByTokenQuery;
    private final DeleteTokenCommand deleteTokenCommand;
    private final UpdateTokenCommand updateTokenCommand;
    private final DeleteTokenByUserIdCommand deleteTokenByUserIdCommand;
    private final GetUserQuery getUserQuery;
    private final GetUserByEmailQuery getUserByEmailQuery;

    @Override
    public JwtToken createToken(User user) {
        return createTokenCommand.execute(generateJwtToken(user));
    }

    @Override
    public String getUserNameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    @Override
    public JwtToken refreshToken(String oldToken) {
        JwtToken token = getJwtByTokenQuery.execute(oldToken);
        verifyExpiration(token);
        User user = getUserQuery.execute(token.getUserId());
        token.setAccessToken(buildAccessToken(user, getExpireDate()));
        token.setExpiryDate(getExpireDate().toInstant());
        return updateTokenCommand.execute(token);
    }

    @Override
    public boolean validateJwtToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parse(token);
            return true;
        } catch (MalformedJwtException ex) {
            throw new APIException(HttpStatus.BAD_REQUEST, "Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            throw new APIException(HttpStatus.BAD_REQUEST, "Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            throw new APIException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            throw new APIException(HttpStatus.BAD_REQUEST, "JWT claims string is empty.");
        }
    }

    @Override
    public void deleteTokenByEmail(String email) {
        User user = getUserByEmailQuery.execute(email);
        deleteTokenByUserIdCommand.execute(user.getId());
    }

    private Key key() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecret)
        );
    }

    private void verifyExpiration(JwtToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            deleteTokenCommand.execute(token.getId());
            throw new APIException(HttpStatus.FORBIDDEN, "Refresh token was expired. Please make a new signing request");
        }
    }

    private JwtToken generateJwtToken(User user) {
        Date expireDate = getExpireDate();

        String token = buildAccessToken(user, expireDate);

        return JwtToken.builder()
                .userId(user.getId())
                .accessToken(token)
                .type(TOKEN_TYPE)
                .expiryDate(expireDate.toInstant())
                .build();
    }

    private Date getExpireDate() {
        Date currentDate = new Date();
        return new Date(currentDate.getTime() + tokenExpirationTime);
    }

    private String buildAccessToken(User user, Date expireDate) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(key())
                .compact();
    }

}
