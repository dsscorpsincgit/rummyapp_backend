package com.rummy.app.Dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class LoginResponse {

    private UUID id;
    private String username;
    private String token;
    private LocalDateTime lastLogin;

    public LoginResponse(UUID id, String username,
                         String token, LocalDateTime lastLogin) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.lastLogin = lastLogin;
    }

    public UUID getId() { return id; }
    public String getUsername() { return username; }
    public String getToken() { return token; }
    public LocalDateTime getLastLogin() { return lastLogin; }
}
