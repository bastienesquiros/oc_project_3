package com.besquiros.chatop.controller;

import com.besquiros.chatop.dto.response.AuthResponse;
import com.besquiros.chatop.dto.request.LoginRequest;
import com.besquiros.chatop.dto.request.RegisterRequest;
import com.besquiros.chatop.dto.response.UserResponse;
import com.besquiros.chatop.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    /**
     * Placeholder — will return the current user from JWT once Spring Security is fully configured.
     * For now, requires a userId query parameter.
     */
    @GetMapping("/me")
    public ResponseEntity<UserResponse> me(@RequestParam Long userId) {
        return ResponseEntity.ok(authService.me(userId));
    }
}
