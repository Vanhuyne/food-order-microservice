package com.vanhuy.user_service.controller;

import com.vanhuy.user_service.component.JwtUtil;
import com.vanhuy.user_service.dto.AuthResponse;
import com.vanhuy.user_service.dto.LoginRequest;
import com.vanhuy.user_service.dto.RegisterRequest;
import com.vanhuy.user_service.dto.ValidTokenResponse;
import com.vanhuy.user_service.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {
    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {

        AuthResponse response = authService.authenticate(loginRequest);
        log.info("Login successful for user: {}", loginRequest.getUsername());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(authService.register(registerRequest));
    }

    @PostMapping("/validateToken")
    public ResponseEntity<ValidTokenResponse> validateToken(@RequestParam("token") String token) {
        boolean valid = jwtUtil.validateToken(token);
        ValidTokenResponse response = new ValidTokenResponse(valid);
        return ResponseEntity.ok(response);
    }
}
