package com.example.midterm.service;

import com.example.midterm.dto.GameDTO;

import java.util.List;

public interface GameService {
    List<GameDTO> getAll();
    GameDTO getById(Long id);
    GameDTO create(GameDTO gameDTO);
    GameDTO update(Long id, GameDTO gameDTO);
    void delete(Long id);
}
