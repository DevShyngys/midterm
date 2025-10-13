package com.example.midterm.mapper;

import com.example.midterm.dto.PlatformDTO;
import com.example.midterm.model.Platform;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlatformMapper {
    PlatformDTO toDto(Platform platform);
    Platform toEntity(PlatformDTO platformDTO);

    List<PlatformDTO> toDtoList(List<Platform> platforms);
}
