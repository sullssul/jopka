package ru.bash.jopka.controller.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bash.jopka.controller.auth.dto.LoginRequest;
import ru.bash.jopka.controller.auth.dto.RefreshTokenRequest;
import ru.bash.jopka.security.auth.AuthService;
import ru.bash.jopka.security.jwt.model.JwtToken;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin("${rest.cross.origin}")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signing")
    public JwtToken authenticateUser(@RequestBody @Valid LoginRequest request) {
        return authService.authAndCreateToken(request);
    }

    @PostMapping("/refresh")
    public JwtToken refreshToken(@RequestBody @Valid RefreshTokenRequest request) {
        return authService.refreshToken(request);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return new ResponseEntity<>(authService.logout(), HttpStatus.OK);
    }
}
