package com.example.midterm.dto;

import com.example.midterm.mapper.DeveloperMapper;
import com.example.midterm.model.Developer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class DeveloperMapperTest {

    @Autowired
    private DeveloperMapper developerMapper;

    @Test
    void convertEntitytoDto(){
        Developer developer = new Developer(1L, "Dev1", "USA");
        DeveloperDTO dto = developerMapper.toDto(developer);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(developer.getId(), dto.getId());
        Assertions.assertEquals(developer.getName(), dto.getName());
        Assertions.assertEquals(developer.getCountry(), dto.getCountry());

    }

    @Test
    void convertDtoToEntity(){
        DeveloperDTO developerDTO = new DeveloperDTO(2L, "Dev2", "Kz");
        Developer developer = developerMapper.toEntity(developerDTO);

        Assertions.assertNotNull(developer);
        Assertions.assertEquals(developerDTO.getId(), developer.getId());
        Assertions.assertEquals(developerDTO.getName(), developer.getName());
        Assertions.assertEquals(developerDTO.getCountry(), developer.getCountry());
    }

    @Test
    void convertEntityListToDtoList() {
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer(1L, "Epic Games", "USA"));
        developers.add(new Developer(2L, "Valve", "USA"));

        List<DeveloperDTO> dtoList = developerMapper.toDtoList(developers);

        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(developers.size(), dtoList.size());

        for (int i = 0; i < developers.size(); i++) {
            Developer dev = developers.get(i);
            DeveloperDTO dto = dtoList.get(i);
            Assertions.assertEquals(dev.getId(), dto.getId());
            Assertions.assertEquals(dev.getName(), dto.getName());
            Assertions.assertEquals(dev.getCountry(), dto.getCountry());
        }
    }

}
