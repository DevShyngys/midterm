package com.example.midterm.controller;

import com.example.midterm.dto.PlatformDTO;
import com.example.midterm.service.impl.PlatformServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/platforms")
public class PlatformController {
    private final PlatformServiceImpl platformService;

    @PostMapping
    public PlatformDTO createPlatform(@RequestBody PlatformDTO platformDTO){
        return platformService.create(platformDTO);
    }

    @GetMapping
    public List<PlatformDTO> getAllPlatforms(){
        return platformService.getAll();
    }

    @GetMapping("/{id}")
    public PlatformDTO getById(@PathVariable Long id){
        return platformService.getById(id);
    }

    @PutMapping("/{id}")
    public PlatformDTO updateById(@PathVariable Long id, @RequestBody PlatformDTO platformDTO ){
        return platformService.update(id, platformDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        platformService.delete(id);
    }

}
