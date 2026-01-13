
package com.rummy.app.service;

import com.rummy.app.entity.Player;
import com.rummy.app.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public Player register(Player player) {
        return repository.save(player);
    }

    public List<Player> getAllPlayers() {
        return repository.findAll();
    }
}
