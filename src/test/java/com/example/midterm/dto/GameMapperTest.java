package com.example.midterm.dto;

import com.example.midterm.mapper.GameMapper;
import com.example.midterm.model.Developer;
import com.example.midterm.model.Game;
import com.example.midterm.model.Platform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class GameMapperTest {
    @Autowired
    private GameMapper gameMapper;

    @Test
    void convertEntityToDto(){
        Developer developer = new Developer(1L, "Dev1", "KZ");
        Platform platform1 = new Platform(2L, "Plat2", "Manu2");
        Platform platform2 = new Platform(3L, "Plat3", "Manu3");

        Game game = new Game(1L, "GTA5", 8.5, developer, List.of(platform1,platform2));

        GameDTO gameDTO = gameMapper.toDto(game);

        Assertions.assertNotNull(gameDTO);
        Assertions.assertEquals(game.getId(), gameDTO.getId());
        Assertions.assertEquals(game.getTitle(), gameDTO.getTitle());
        Assertions.assertEquals(game.getRating(), gameDTO.getRating());
        Assertions.assertNotNull(gameDTO.getDeveloper());
        Assertions.assertEquals(game.getDeveloper().getName(), gameDTO.getDeveloper().getName());
        Assertions.assertEquals(game.getPlatforms().size(), gameDTO.getPlatforms().size());
    }

    @Test
    void convertDtoToEntity(){
        DeveloperDTO developerDTO = new DeveloperDTO(1L, "Dev1", "KZ");
        PlatformDTO platformDTO1 = new PlatformDTO(2L, "Plat2", "Manu2");
        PlatformDTO platformDTO2 = new PlatformDTO(3L, "Plat3", "Manu3");

        GameDTO gameDTO = new GameDTO(1L, "GTA5", 8.5, developerDTO, List.of(platformDTO1,platformDTO2));

        Game game = gameMapper.toEntity(gameDTO);

        Assertions.assertNotNull(game);
        Assertions.assertEquals(game.getId(), gameDTO.getId());
        Assertions.assertEquals(game.getTitle(), gameDTO.getTitle());
        Assertions.assertEquals(game.getRating(), gameDTO.getRating());
        Assertions.assertNotNull(gameDTO.getDeveloper());
        Assertions.assertEquals(game.getDeveloper().getName(), gameDTO.getDeveloper().getName());
        Assertions.assertEquals(game.getPlatforms().size(), gameDTO.getPlatforms().size());
    }

    @Test
    void convertEntitylistToDtoList(){
        Developer developer1 = new Developer(4L, "Dev1", "KZ");
        Developer developer2 = new Developer(5L, "Dev2", "KZ");
        Platform platform5 = new Platform(5L, "Plat5", "Manu5");
        Platform platform6 = new Platform(6L, "Plat6", "Manu6");

        List<Game> games = new ArrayList<>();
        games.add(new Game(1L, "GTA5", 8.5, developer1, List.of(platform5,platform6)));
        games.add(new Game(2L, "GTA4", 8.0, developer2, List.of(platform5,platform6)));

        Assertions.assertN;

    }
}
