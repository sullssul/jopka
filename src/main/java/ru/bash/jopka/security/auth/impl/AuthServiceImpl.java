package ru.bash.jopka.security.auth.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.bash.jopka.business.user.model.User;
import ru.bash.jopka.business.user.usecase.GetUserByEmailQuery;
import ru.bash.jopka.controller.auth.dto.LoginRequest;
import ru.bash.jopka.controller.auth.dto.RefreshTokenRequest;
import ru.bash.jopka.security.auth.AuthService;
import ru.bash.jopka.security.jwt.JwtTokenService;
import ru.bash.jopka.security.jwt.model.JwtToken;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;
    private final GetUserByEmailQuery getUserByEmailQuery;

    @Override
    public JwtToken authAndCreateToken(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String email = ((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername();
        User user = getUserByEmailQuery.execute(email);

        return jwtTokenService.createToken(user);
    }

    @Override
    public JwtToken refreshToken(RefreshTokenRequest request) {
        return jwtTokenService.refreshToken(request.getToken());
    }

    @Override
    public String logout() {
        String email = ((org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal())
                .getUsername();

        jwtTokenService.deleteTokenByEmail(email);
        return "Успешно выполнено!";
    }
}
