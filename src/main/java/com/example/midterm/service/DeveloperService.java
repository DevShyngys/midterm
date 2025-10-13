package com.example.midterm.service;

import com.example.midterm.dto.DeveloperDTO;
import com.example.midterm.mapper.DeveloperMapper;
import com.example.midterm.model.Developer;
import com.example.midterm.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperService {
    private final DeveloperRepository developerRepository;
    private  final DeveloperMapper developerMapper;

    public DeveloperDTO create(DeveloperDTO developerDTO){
        Developer developer = developerMapper.toEntity(developerDTO);
        Developer saved = developerRepository.save(developer);

        return developerMapper.toDto(saved);
    }

    public List<DeveloperDTO> getAll(){
        return developerMapper.toDtoList(developerRepository.findAll());
    }

    public DeveloperDTO getById(Long id){
        return developerMapper.toDto(developerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No developer with this id" + id)));
    }

    public DeveloperDTO update(Long id, DeveloperDTO developerDTO){
        Developer existing = developerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No developer with this id" + id));

        existing.setName(developerDTO.getName());
        existing.setCountry(developerDTO.getCountry());
        Developer updated = developerRepository.save(existing);

        return developerMapper.toDto(updated);
    }

    public void delete(Long id){
        developerRepository.deleteById(id);
    }
}