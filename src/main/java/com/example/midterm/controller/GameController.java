package com.example.midterm.controller;

import com.example.midterm.dto.GameDTO;
import com.example.midterm.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @PostMapping
    public GameDTO createGame(@RequestBody GameDTO gameDTO){
        return gameService.create(gameDTO);
    }

    @GetMapping
    public List<GameDTO> getAllGames(){
        return gameService.getAll();
    }

    @GetMapping("/{id}")
    public GameDTO getById(@PathVariable Long id){
        return gameService.getById(id);
    }

    @PutMapping("/{id}")
    public GameDTO updateById(@PathVariable Long id, @RequestBody GameDTO gameDTO){
        return gameService.update(id, gameDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        gameService.delete(id);
    }
}
