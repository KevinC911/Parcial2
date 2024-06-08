package com.parcial2.domain.DTOs;

import lombok.Data;

@Data
public class AddMedicProcedureDTO {
    private String code;
    private String doctor_identifier;
    private String speciality;
    private String appointment_code;
}
