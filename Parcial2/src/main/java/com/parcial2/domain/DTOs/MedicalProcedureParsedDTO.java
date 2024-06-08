package com.parcial2.domain.DTOs;

import com.parcial2.domain.Entities.MedicalAppointment;
import lombok.Data;

import java.util.List;

@Data
public class MedicalProcedureParsedDTO {
    private String code;
    private List<String> doctors;
    private List<String> specialities;
    private MedicalAppointment appointment;

    public void addDoctor(String item) {
        doctors.add(item);
    }

    public void addSpeciality(String item) {
        specialities.add(item);
    }

}
