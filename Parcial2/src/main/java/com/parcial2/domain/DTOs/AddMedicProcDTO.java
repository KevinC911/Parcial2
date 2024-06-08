package com.parcial2.domain.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class AddMedicProcDTO {
    @NotBlank
    private String code;

    private List<@NotBlank String> doctors;

    private List<@NotBlank String> specialities;
}
