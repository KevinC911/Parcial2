package com.parcial2.services;

import com.parcial2.domain.DTOs.AddMedicProcDTO;
import com.parcial2.domain.Entities.MedicalAppointment;
import com.parcial2.domain.Entities.MedicalProcedure;
import com.parcial2.domain.Entities.Speciality;
import com.parcial2.domain.Entities.User;

import java.util.List;

public interface MedicalProcedureService {
    void addMedicalProcedures(String code, List<User> doctors, List<Speciality> specialities, MedicalAppointment medAppointment);
    void addMedicalProcedure(String code, User doctor, Speciality speciality, MedicalAppointment medAppointment);
    List<MedicalProcedure> getAllByCode(String code);

}
