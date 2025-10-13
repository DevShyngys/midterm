package com.example.midterm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {
    private Long id;
    private String title;
    private double rating;
    private DeveloperDTO developers;
    private PlatformDTO platforms;
}
