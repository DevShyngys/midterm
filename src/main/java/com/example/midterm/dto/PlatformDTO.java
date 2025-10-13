package com.example.midterm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatformDTO {
    private Long id;
    private String name;
    private String manufacturer;
}
