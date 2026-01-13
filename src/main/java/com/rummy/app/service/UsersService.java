package com.rummy.app.service;

import com.rummy.app.Dto.UsersRequest;
import com.rummy.app.entity.Users;
import com.rummy.app.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // ================= CREATE USER =================
    public Users createUser(UsersRequest request) {

        usersRepository.findByUsername(request.getUsername())
                .ifPresent(u -> {
                    throw new RuntimeException("Username already exists");
                });

        usersRepository.findByEmail(request.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("Email already exists");
                });

        usersRepository.findByMobile(request.getMobile())
                .ifPresent(u -> {
                    throw new RuntimeException("Mobile already exists");
                });

        Users user = new Users();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());

        return usersRepository.save(user);
    }

    // ================= GET BY ID =================
    public Users getUserById(UUID id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // ================= GET ALL =================
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
