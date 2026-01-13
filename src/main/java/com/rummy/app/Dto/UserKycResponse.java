package com.rummy.app.Dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserKycResponse {

    private UUID id;
    private UUID userId;
    private boolean verified;
    private LocalDateTime verifiedAt;

    public UserKycResponse(UUID id, UUID userId, boolean verified, LocalDateTime verifiedAt) {
        this.id = id;
        this.userId = userId;
        this.verified = verified;
        this.verifiedAt = verifiedAt;
    }

    public UUID getId() { return id; }
    public UUID getUserId() { return userId; }
    public boolean isVerified() { return verified; }
    public LocalDateTime getVerifiedAt() { return verifiedAt; }
}
