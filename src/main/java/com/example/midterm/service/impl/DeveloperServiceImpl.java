package com.example.midterm.service.impl;

import com.example.midterm.dto.DeveloperDTO;
import com.example.midterm.mapper.DeveloperMapper;
import com.example.midterm.model.Developer;
import com.example.midterm.repository.DeveloperRepository;
import com.example.midterm.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperRepository developerRepository;
    private  final DeveloperMapper developerMapper;

    @Override
    public DeveloperDTO create(DeveloperDTO developerDTO){
        Developer developer = developerMapper.toEntity(developerDTO);
        Developer saved = developerRepository.save(developer);

        return developerMapper.toDto(saved);
    }

    @Override
    public List<DeveloperDTO> getAll(){
        return developerMapper.toDtoList(developerRepository.findAll());
    }

    @Override
    public DeveloperDTO getById(Long id){
        return developerMapper.toDto(developerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No developer with this id" + id)));
    }

    @Override
    public DeveloperDTO update(Long id, DeveloperDTO developerDTO){
        Developer existing = developerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No developer with this id" + id));

        existing.setName(developerDTO.getName());
        existing.setCountry(developerDTO.getCountry());
        Developer updated = developerRepository.save(existing);

        return developerMapper.toDto(updated);
    }

    @Override
    public void delete(Long id){
        developerRepository.deleteById(id);
    }
}