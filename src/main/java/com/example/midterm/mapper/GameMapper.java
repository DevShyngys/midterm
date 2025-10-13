package com.example.midterm.mapper;

import com.example.midterm.dto.GameDTO;
import com.example.midterm.model.Game;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses ={DeveloperMapper.class, PlatformMapper.class})
public interface GameMapper {
    GameDTO toDto(Game game);
    Game toEntity(GameDTO gameDTO);

    List<GameDTO> toDtoList(List<Game> games);
}
