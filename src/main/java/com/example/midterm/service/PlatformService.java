package com.example.midterm.service;

import com.example.midterm.dto.PlatformDTO;
import com.example.midterm.mapper.PlatformMapper;
import com.example.midterm.model.Platform;
import com.example.midterm.repository.PlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlatformService {
    private final PlatformMapper platformMapper;
    private final PlatformRepository platformRepository;

    public PlatformDTO create(PlatformDTO platformDTO){
        Platform platform = platformMapper.toEntity(platformDTO);
        Platform saved = platformRepository.save(platform);

        return platformMapper.toDto(saved);
    }

    public List<PlatformDTO> getAll(){
        return platformMapper.toDtoList(platformRepository.findAll());
    }

    public PlatformDTO getById(Long id){
        return platformMapper.toDto(platformRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No platform with this id" + id)));
    }

    public PlatformDTO update(Long id, PlatformDTO platformDTO){
        Platform existing = platformRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No platform with this id" + id));

        existing.setName(platformDTO.getName());
        existing.setManufacturer(platformDTO.getManufacturer());
        Platform updated = platformRepository.save(existing);

        return platformMapper.toDto(updated);
    }

    public void delete(Long id){
        platformRepository.deleteById(id);
    }
}
