package com.rummy.app.controller;

import com.rummy.app.Dto.UserKycRequest;
import com.rummy.app.Dto.UserKycResponse;
import com.rummy.app.service.UserKycService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/kyc")
public class UserKycController {

    private final UserKycService service;

    public UserKycController(UserKycService service) {
        this.service = service;
    }

    // ===== SUBMIT / UPDATE KYC =====
    @PostMapping("/submit")
    public ResponseEntity<UserKycResponse> submitKyc(
            @RequestBody UserKycRequest request) {
        return ResponseEntity.ok(service.submitKyc(request));
    }

    // ===== GET KYC =====
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserKycResponse> getKyc(
            @PathVariable UUID userId) {
        return ResponseEntity.ok(service.getKycByUserId(userId));
    }
}
