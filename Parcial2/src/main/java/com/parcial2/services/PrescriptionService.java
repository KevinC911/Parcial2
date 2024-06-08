package com.parcial2.services;

import com.parcial2.domain.DTOs.SavePrescriptionDTO;
import com.parcial2.domain.Entities.Prescription;

import java.util.List;
import java.util.UUID;

public interface PrescriptionService {
    List<Prescription> findAll();
    Prescription findById(UUID code);
    void savePrescription(SavePrescriptionDTO savePrescriptionDTO, UUID doctorId);
}
