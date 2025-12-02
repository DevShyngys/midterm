package com.example.midterm.service;

import com.example.midterm.dto.PlatformDTO;

import java.util.List;

public interface PlatformService {
    List<PlatformDTO> getAll();
    PlatformDTO getById(Long id);
    PlatformDTO create(PlatformDTO platformDTO);
    PlatformDTO update(Long id, PlatformDTO platformDTO);
    void delete(Long id);
}
