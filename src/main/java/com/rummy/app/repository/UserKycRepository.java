package com.rummy.app.repository;

import com.rummy.app.entity.UserKyc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserKycRepository extends JpaRepository<UserKyc, UUID> {

    Optional<UserKyc> findByUserId(UUID userId);

    boolean existsByPanNumber(String panNumber);

    boolean existsByAadhaarNumber(String aadhaarNumber);
}
