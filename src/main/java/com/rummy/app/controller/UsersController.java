package com.rummy.app.controller;

import com.rummy.app.Dto.UsersRequest;
import com.rummy.app.entity.Users;
import com.rummy.app.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    // ================= CREATE USER =================
    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody UsersRequest request) {
        Users user = usersService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    // ================= GET USER BY ID =================
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable UUID id) {
        Users user = usersService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // ================= GET ALL USERS =================
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = usersService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
