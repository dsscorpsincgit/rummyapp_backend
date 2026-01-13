package com.rummy.app.Dto;

import com.rummy.app.Enums.KycStatus;
import com.rummy.app.Enums.Status;

import java.time.LocalDateTime;
import java.util.UUID;

public class UsersResponse {

    private UUID id;
    private String username;
    private String email;
    private String mobile;
    private Status status;
    private KycStatus kycStatus;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;

    // Constructor
    public UsersResponse(UUID id, String username, String email, String mobile,
                         Status status, KycStatus kycStatus,
                         LocalDateTime createdAt, LocalDateTime lastLogin) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.status = status;
        this.kycStatus = kycStatus;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
    }

    // ===================== GETTERS =====================
    public UUID getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getMobile() { return mobile; }
    public Status getStatus() { return status; }
    public KycStatus getKycStatus() { return kycStatus; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getLastLogin() { return lastLogin; }

    // ===================== SETTERS =====================
    public void setId(UUID id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public void setStatus(Status status) { this.status = status; }
    public void setKycStatus(KycStatus kycStatus) { this.kycStatus = kycStatus; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; }
}
