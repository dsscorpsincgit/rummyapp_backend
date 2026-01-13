
package com.rummy.app.controller;

import com.rummy.app.entity.Player;
import com.rummy.app.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public Player register(@RequestBody Player player) {
        return service.register(player);
    }

    @GetMapping
    public List<Player> allPlayers() {
        return service.getAllPlayers();
    }
}
