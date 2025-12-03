package com.example.midterm.service;


import com.example.midterm.dto.PlatformDTO;
import com.example.midterm.model.Platform;
import com.example.midterm.repository.PlatformRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class PlatformServiceTest {

    @Autowired
    private PlatformService platformService;

    @Autowired
    private PlatformRepository platformRepository;

    @Test
    @Transactional
    void getAllTest(){
        platformRepository.save(new Platform(null,"Platform1", "USA" ));
        platformRepository.save(new Platform(null,"Platform2", "KZ" ));

        List<PlatformDTO> result = platformService.getAll();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size() >= 2);

        for(PlatformDTO dto : result){
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getName());
            Assertions.assertNotNull(dto.getManufacturer());
        }

    }


    @Test
    @Transactional
    void getByIdTest(){
        Platform saved = platformRepository.save((new Platform(null,"Platform1", "USA" )));

        PlatformDTO dto = platformService.getById(saved.getId());
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(saved.getId(), dto.getId());
        Assertions.assertEquals(saved.getName(), dto.getName());
        Assertions.assertEquals(saved.getManufacturer(), dto.getManufacturer());

        Assertions.assertThrows(RuntimeException.class, () -> platformService.getById(-1L));

    }


    @Test
    @Transactional
    void createTest(){
        PlatformDTO input = new PlatformDTO(null, "plat1", "RUS");

        PlatformDTO created = platformService.create(input);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals(input.getName(), created.getName());
        Assertions.assertEquals(input.getManufacturer(), created.getManufacturer());
    }

    @Test
    @Transactional
    void updateTest(){
        Platform saved = platformRepository.save((new Platform(null,"old", "USA" )));
        PlatformDTO updateDTO = new PlatformDTO(null, "new", "RUS");

        PlatformDTO updated = platformService.update(saved.getId(), updateDTO);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals(updateDTO.getName(), updated.getName());
        Assertions.assertEquals(updateDTO.getManufacturer(), updated.getManufacturer());
    }

    @Test
    @Transactional
    void deleteTest(){
        Platform saved = platformRepository.save((new Platform(null,"to delete", "USA" )));

        platformService.delete(saved.getId());

        Assertions.assertThrows(RuntimeException.class, () -> platformService.getById(saved.getId()));

    }
}
}
