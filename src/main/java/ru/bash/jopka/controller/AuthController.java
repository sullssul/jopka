package ru.bash.jopka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.bash.jopka.controller.dto.auth.LoginRequest;
import ru.bash.jopka.controller.dto.auth.JWTAuthResponse;
import ru.bash.jopka.security.JwtTokenProvider;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin("${rest.cross.origin}")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;


    @PostMapping("/signin")
    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);
        JWTAuthResponse jwtAuthResponse = JWTAuthResponse.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .build();

        return ResponseEntity.ok(jwtAuthResponse);
    }
}
