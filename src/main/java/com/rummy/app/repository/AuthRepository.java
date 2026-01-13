package com.rummy.app.repository;

import com.rummy.app.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AuthRepository extends JpaRepository<Login, UUID> {

    Optional<Login> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByMobile(String mobile);  
    
    boolean existsByEmail(String email);
}
