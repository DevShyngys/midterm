package com.example.midterm.service;

import com.example.midterm.dto.DeveloperDTO;

import java.util.List;

public interface DeveloperService {

    List<DeveloperDTO> getAll();
    DeveloperDTO getById(Long id);
    DeveloperDTO create(DeveloperDTO developerDTO);
    DeveloperDTO update(Long id, DeveloperDTO developerDTO);
    void delete(Long id);
}
