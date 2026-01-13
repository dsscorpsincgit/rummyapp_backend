package com.rummy.app.service;

import com.rummy.app.Dto.UserKycRequest;
import com.rummy.app.Dto.UserKycResponse;
import com.rummy.app.entity.UserKyc;
import com.rummy.app.repository.UserKycRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserKycService {

    private final UserKycRepository repository;

    public UserKycService(UserKycRepository repository) {
        this.repository = repository;
    }

    // ================= SUBMIT / UPDATE KYC =================
    public UserKycResponse submitKyc(UserKycRequest request) {

        UserKyc kyc = repository.findByUserId(request.getUserId())
                .orElse(new UserKyc());

        if (kyc.getId() == null) {
            if (repository.existsByPanNumber(request.getPanNumber()))
                throw new RuntimeException("PAN already used");

            if (repository.existsByAadhaarNumber(request.getAadhaarNumber()))
                throw new RuntimeException("Aadhaar already used");
        }

        kyc.setUserId(request.getUserId());
        kyc.setPanNumber(request.getPanNumber());
        kyc.setAadhaarNumber(request.getAadhaarNumber());

        // Real-time verification simulation
        kyc.setVerified(true);
        kyc.setVerifiedAt(LocalDateTime.now());

        UserKyc saved = repository.save(kyc);

        return new UserKycResponse(
                saved.getId(),
                saved.getUserId(),
                saved.isVerified(),
                saved.getVerifiedAt()
        );
    }

    // ================= GET KYC =================
    public UserKycResponse getKycByUserId(java.util.UUID userId) {

        UserKyc kyc = repository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("KYC not found"));

        return new UserKycResponse(
                kyc.getId(),
                kyc.getUserId(),
                kyc.isVerified(),
                kyc.getVerifiedAt()
        );
    }
}
