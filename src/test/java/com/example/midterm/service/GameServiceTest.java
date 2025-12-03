package com.example.midterm.service;

import com.example.midterm.dto.GameDTO;
import com.example.midterm.model.Game;
import com.example.midterm.repository.GameRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class GameServiceTest {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameRepository gameRepository;

    @Test
    @Transactional
    void getAllTest() {
        gameRepository.save(new Game(null, "Game1", 9.5, null, null));
        gameRepository.save(new Game(null, "Game2", 8.2, null, null));

        List<GameDTO> result = gameService.getAll();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size() >= 2);

        for (GameDTO dto : result) {
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getTitle());
            Assertions.assertNotNull(dto.getRating());
        }
    }

    @Test
    @Transactional
    void getByIdTest() {
        Game saved = gameRepository.save(new Game(null, "Game3", 7.5, null, null));

        GameDTO dto = gameService.getById(saved.getId());

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(saved.getId(), dto.getId());
        Assertions.assertEquals(saved.getTitle(), dto.getTitle());
        Assertions.assertEquals(saved.getRating(), dto.getRating());

        Assertions.assertThrows(RuntimeException.class, () -> gameService.getById(-1L));
    }

    @Test
    @Transactional
    void createTest() {
        GameDTO input = new GameDTO(null, "NewGame", 9.0, null, null);

        GameDTO created = gameService.create(input);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals(input.getTitle(), created.getTitle());
        Assertions.assertEquals(input.getRating(), created.getRating());
    }

    @Test
    @Transactional
    void updateTest() {
        Game saved = gameRepository.save(new Game(null, "OldGame", 6.5, null, null));

        GameDTO updateDTO = new GameDTO(saved.getId(), "UpdatedGame", 8.0, null, null);

        GameDTO updated = gameService.update(saved.getId(), updateDTO);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals(updateDTO.getTitle(), updated.getTitle());
        Assertions.assertEquals(updateDTO.getRating(), updated.getRating());
    }

    @Test
    @Transactional
    void deleteTest() {
        Game saved = gameRepository.save(new Game(null, "ToDeleteGame", 5.0, null, null));

        gameService.delete(saved.getId());

        Assertions.assertThrows(RuntimeException.class, () -> gameService.getById(saved.getId()));
    }
}