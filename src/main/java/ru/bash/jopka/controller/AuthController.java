package ru.bash.jopka.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.bash.jopka.controller.dto.auth.LoginRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin("${rest.cross.origin}")
public class AuthController {
    private final AuthenticationManager authenticationManager;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }
}
