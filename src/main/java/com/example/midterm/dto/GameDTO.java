package com.example.midterm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {
    private Long id;

    private String title;
    private double rating;

    private DeveloperDTO developer;
    private List<PlatformDTO> platforms;
}
