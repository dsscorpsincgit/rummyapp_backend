
package com.rummy.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name="players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int chips;

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public int getChips() { return chips; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setChips(int chips) { this.chips = chips; }
}
