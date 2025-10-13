package com.example.midterm.service;

import com.example.midterm.dto.GameDTO;
import com.example.midterm.mapper.GameMapper;
import com.example.midterm.model.Game;
import com.example.midterm.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.criteria.JpaConflictUpdateAction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private  final GameMapper gameMapper;

    public GameDTO create(GameDTO gameDTO){
        Game game = gameMapper.toEntity(gameDTO);
        Game saved = gameRepository.save(game);

        return gameMapper.toDto(saved);
    }

    public List<GameDTO> getAll(){
        return gameMapper.toDtoList(gameRepository.findAll());
    }

    public GameDTO getById(Long id){
        return gameMapper.toDto(gameRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No game with this id" + id)));
    }

    public GameDTO update(Long id, GameDTO gameDTO){
        Game existing = gameRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No game with this id" + id));
        existing.setTitle(gameDTO.getTitle());
        existing.setRating(gameDTO.getRating());
        Game updated = gameRepository.save(existing);

        return gameMapper.toDto(updated);
    }

    public void delete(Long id){
        gameRepository.deleteById(id);
    }
}
