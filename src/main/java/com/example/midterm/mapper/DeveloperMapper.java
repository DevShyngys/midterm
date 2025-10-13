package com.example.midterm.mapper;

import com.example.midterm.dto.DeveloperDTO;
import com.example.midterm.model.Developer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeveloperMapper {
    DeveloperDTO toDto(Developer developer);
    Developer toEntity(DeveloperDTO developerDTO);

    List<DeveloperDTO> toDtoList(List<Developer> developers);
}
