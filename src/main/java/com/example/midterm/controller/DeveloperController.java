package com.example.midterm.controller;

import com.example.midterm.dto.DeveloperDTO;
import com.example.midterm.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/developers")
public class DeveloperController {
    private final DeveloperService developerService;

    @PostMapping
    public DeveloperDTO createDeveloper(@RequestBody DeveloperDTO developerDTO){
        return developerService.create(developerDTO);
    }

    @GetMapping
    public List<DeveloperDTO> getAllDevelopers(){
        return developerService.getAll();
    }

    @GetMapping("/{id}")
    public DeveloperDTO getById(@PathVariable Long id){
        return developerService.getById(id);
    }

    @PutMapping("/{id}")
    public DeveloperDTO updateById(@PathVariable Long id, @RequestBody DeveloperDTO developerDTO ){
        return developerService.update(id, developerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        developerService.delete(id);
    }
}
