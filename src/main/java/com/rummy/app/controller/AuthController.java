package com.rummy.app.controller;

import com.rummy.app.Dto.LoginRegisterRequest;
import com.rummy.app.Dto.LoginResponse;
import com.rummy.app.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // ================= REGISTER =================
    @PostMapping("/register")
    public ResponseEntity<LoginResponse> register(
            @RequestBody LoginRegisterRequest request) {

        LoginResponse response = authService.register(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRegisterRequest request) {

        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    // ================= HEALTH CHECK =================
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Auth Service is Running ✅");
    }
}
