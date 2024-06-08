package com.parcial2.domain.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddSpecialityDTO {
    @Pattern(regexp = "[A-Z]{4}$")
    private String code;

    @NotBlank
    private String name;
}
