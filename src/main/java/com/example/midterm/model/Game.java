package com.example.midterm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private double rating;

    @ManyToOne
    @JoinColumns(name = "developer_id")
    private Developer developer;

    @ManyToMany
    @JoinTable(name = "game_platform",
            joinColumns = @JoinColumns("game_id"),
            inverseJoinColumns = @JoinColumns("platform_id"))
    private List<Platform> platforms;
}
