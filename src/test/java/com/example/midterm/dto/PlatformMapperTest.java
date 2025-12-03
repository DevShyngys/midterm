package com.example.midterm.dto;

import com.example.midterm.mapper.PlatformMapper;
import com.example.midterm.model.Platform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class PlatformMapperTest {

    @Autowired
    private PlatformMapper platformMapper;

    @Test
    void convertEntityToDto(){
        Platform platform = new Platform(1L, "Plat1", "Manu1");
        PlatformDTO platformDTO = platformMapper.toDto(platform);

        Assertions.assertNotNull(platformDTO);
        Assertions.assertEquals(platform.getId(), platformDTO.getId());
        Assertions.assertEquals(platform.getName(), platformDTO.getName());
        Assertions.assertEquals(platform.getManufacturer(), platformDTO.getManufacturer());
    }

    @Test
    void convertDtoToEntity(){
        PlatformDTO platformDTO = new PlatformDTO(2L, "Plat2", "Manu2");
        Platform platform = platformMapper.toEntity(platformDTO);

        Assertions.assertNotNull(platform);
        Assertions.assertEquals(platformDTO.getId(), platform.getId());
        Assertions.assertEquals(platformDTO.getName(), platform.getName());
        Assertions.assertEquals(platformDTO.getManufacturer(), platform.getManufacturer());
    }

    @Test
    void convertEntitylistToDtoList() {
        List<Platform> platforms = new ArrayList<>();
        platforms.add(new Platform(1L, "Plat1", "Manu1"));
        platforms.add(new Platform(2L, "Plat2", "Manu2"));

        List<PlatformDTO> dtoList = platformMapper.toDtoList(platforms);

        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(platforms.size(), dtoList.size());

        for (int i = 0; i < platforms.size(); i++) {
            Platform platform = platforms.get(i);
            PlatformDTO platformDTO = dtoList.get(i);

            Assertions.assertEquals(platform.getId(), platformDTO.getId());
            Assertions.assertEquals(platform.getName(), platformDTO.getName());
            Assertions.assertEquals(platform.getManufacturer(), platformDTO.getManufacturer());
        }
    }
}
