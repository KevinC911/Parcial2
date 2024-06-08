package com.parcial2.services;



import com.parcial2.domain.DTOs.SaveMedicalAppointmentDTO;
import com.parcial2.domain.Entities.MedicalAppointment;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface MedicalAppointmentService {

    List<MedicalAppointment> findAll();
    void SaveMedicalAppointment(SaveMedicalAppointmentDTO info);
    void deleteById(UUID id);
    //los siguientes dos sirve para listar las citas medicas por usuario
    List<MedicalAppointment> findByUserId(UUID userId);
    List<MedicalAppointment> findByUsername(String username);

}
