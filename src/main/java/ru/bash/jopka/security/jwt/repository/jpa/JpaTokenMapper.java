package ru.bash.jopka.security.jwt.repository.jpa;

import org.springframework.stereotype.Component;
import ru.bash.jopka.security.jwt.model.JwtToken;

@Component
public class JpaTokenMapper {
    public JwtToken fromJpa(JpaToken jpaToken) {
        return JwtToken.builder()
                .id(jpaToken.getId())
                .accessToken(jpaToken.getToken())
                .userId(jpaToken.getUserId())
                .type(jpaToken.getType())
                .expiryDate(jpaToken.getExpiryDate())
                .build();
    }

    public JpaToken toJpa(JwtToken token) {
        JpaToken jpaToken = new JpaToken();
        jpaToken.setToken(token.getAccessToken());
        jpaToken.setId(token.getId());
        jpaToken.setType(token.getType());
        jpaToken.setExpiryDate(token.getExpiryDate());
        jpaToken.setUserId(token.getUserId());
        return jpaToken;
    }
}
