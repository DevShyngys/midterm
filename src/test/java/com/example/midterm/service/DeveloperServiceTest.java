package com.example.midterm.service;

import com.example.midterm.dto.DeveloperDTO;
import com.example.midterm.model.Developer;
import com.example.midterm.repository.DeveloperRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@SpringBootTest
public class DeveloperServiceTest {

    @Autowired
    private DeveloperService developerService;

    @Autowired
    private DeveloperRepository developerRepository;

    @Test
    @Transactional
    void getAllTest(){
        developerRepository.save(new Developer(null,"Developer1", "USA" ));
        developerRepository.save(new Developer(null,"Developer2", "KZ" ));

        List<DeveloperDTO> result = developerService.getAll();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size() >= 2);

        for(DeveloperDTO dto : result){
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getName());
            Assertions.assertNotNull(dto.getCountry());
        }

    }


    @Test
    @Transactional
    void getByIdTest(){
        Developer saved = developerRepository.save((new Developer(null,"Developer1", "USA" )));

        DeveloperDTO dto = developerService.getById(saved.getId());
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(saved.getId(), dto.getId());
        Assertions.assertEquals(saved.getName(), dto.getName());
        Assertions.assertEquals(saved.getCountry(), dto.getCountry());

        Assertions.assertThrows(RuntimeException.class, () -> developerService.getById(-1L));

    }


    @Test
    @Transactional
    void createTest(){
        DeveloperDTO input = new DeveloperDTO(null, "dev1", "RUS");

        DeveloperDTO created = developerService.create(input);

        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals(input.getName(), created.getName());
        Assertions.assertEquals(input.getCountry(), created.getCountry());
    }

    @Test
    @Transactional
    void updateTest(){
        Developer saved = developerRepository.save((new Developer(null,"old", "USA" )));
        DeveloperDTO updateDTO = new DeveloperDTO(null, "new", "RUS");

        DeveloperDTO updated = developerService.update(saved.getId(), updateDTO);

        Assertions.assertNotNull(updated);
        Assertions.assertEquals(updateDTO.getName(), updated.getName());
        Assertions.assertEquals(updateDTO.getCountry(), updated.getCountry());
    }

    @Test
    @Transactional
    void deleteTest(){
        Developer saved = developerRepository.save((new Developer(null,"to delete", "USA" )));

        developerService.delete(saved.getId());

        Assertions.assertThrows(RuntimeException.class, () -> developerService.getById(saved.getId()));

    }
}
