package com.rummy.app.service;

import com.rummy.app.Dto.LoginRegisterRequest;
import com.rummy.app.Dto.LoginResponse;
import com.rummy.app.entity.Login;
import com.rummy.app.repository.AuthRepository;
import com.rummy.app.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthRepository authRepository, JwtUtil jwtUtil) {
        this.authRepository = authRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // ================= REGISTER =================
    @Override
    public LoginResponse register(LoginRegisterRequest request) {

        validateRegisterRequest(request);

        Login login = new Login();
        login.setUsername(request.getUsername());
        login.setMobile(request.getMobile());
        login.setEmail(request.getEmail());
        login.setPassword(passwordEncoder.encode(request.getPassword()));
        login.setLastLogin(LocalDateTime.now()); 

        Login savedUser = authRepository.save(login);

        String token = jwtUtil.generateToken(savedUser.getUsername());

        return buildResponse(savedUser, token);
    }

    // ================= LOGIN =================
    @Override
    public LoginResponse login(LoginRegisterRequest request) {

        Login user = authRepository.findByUsername(request.getUsername())
                .orElseThrow(() ->
                        new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        user.setLastLogin(LocalDateTime.now());
        authRepository.save(user);

        String token = jwtUtil.generateToken(user.getUsername());

        return buildResponse(user, token);
    }

    // ================= VALIDATION =================
    private void validateRegisterRequest(LoginRegisterRequest request) {

        if (authRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (authRepository.existsByMobile(request.getMobile())) {
            throw new RuntimeException("Mobile already registered");
        }

        if (authRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }
    }

    // ================= RESPONSE BUILDER =================
    private LoginResponse buildResponse(Login user, String token) {
        return new LoginResponse(
                user.getId(),
                user.getUsername(),
                token,
                user.getLastLogin()
                
        );
    }
}
