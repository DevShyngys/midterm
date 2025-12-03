package com.example.midterm.service.impl;

import com.example.midterm.dto.GameDTO;
import com.example.midterm.mapper.GameMapper;
import com.example.midterm.model.Game;
import com.example.midterm.repository.GameRepository;
import com.example.midterm.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private  final GameMapper gameMapper;

    @Override
    public GameDTO create(GameDTO gameDTO){
        Game game = gameMapper.toEntity(gameDTO);
        Game saved = gameRepository.save(game);

        return gameMapper.toDto(saved);
    }

    @Override
    public List<GameDTO> getAll(){
        return gameMapper.toDtoList(gameRepository.findAll());
    }

    @Override
    public GameDTO getById(Long id){
        return gameMapper.toDto(gameRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No game with this id" + id)));
    }

    @Override
    public GameDTO update(Long id, GameDTO gameDTO){
        Game existing = gameRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No game with this id" + id));
        existing.setTitle(gameDTO.getTitle());
        existing.setRating(gameDTO.getRating());
        Game updated = gameRepository.save(existing);

        return gameMapper.toDto(updated);
    }

    @Override
    public void delete(Long id){
        gameRepository.deleteById(id);
    }
}
