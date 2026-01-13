package com.rummy.app.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_kyc")
public class UserKyc {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false, unique = true)
    private String panNumber;

    @Column(nullable = false, unique = true)
    private String aadhaarNumber;

    private boolean verified;
    private LocalDateTime verifiedAt;

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID();
        this.verified = false;
    }

    // getters & setters
    public UUID getId() { return id; }
    public UUID getUserId() { return userId; }
    public String getPanNumber() { return panNumber; }
    public String getAadhaarNumber() { return aadhaarNumber; }
    public boolean isVerified() { return verified; }
    public LocalDateTime getVerifiedAt() { return verifiedAt; }

    public void setUserId(UUID userId) { this.userId = userId; }
    public void setPanNumber(String panNumber) { this.panNumber = panNumber; }
    public void setAadhaarNumber(String aadhaarNumber) { this.aadhaarNumber = aadhaarNumber; }
    public void setVerified(boolean verified) { this.verified = verified; }
    public void setVerifiedAt(LocalDateTime verifiedAt) { this.verifiedAt = verifiedAt; }
}
