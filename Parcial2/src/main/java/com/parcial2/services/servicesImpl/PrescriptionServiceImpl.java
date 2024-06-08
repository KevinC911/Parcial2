package com.parcial2.services.servicesImpl;

import com.parcial2.domain.DTOs.SavePrescriptionDTO;
import com.parcial2.domain.Entities.MedicalAppointment;
import com.parcial2.domain.Entities.Prescription;
import com.parcial2.domain.Entities.User;
import com.parcial2.repositories.MedicalAppointmentRepository;
import com.parcial2.repositories.PrescriptionRepository;
import com.parcial2.repositories.UserRepository;
import com.parcial2.services.PrescriptionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final UserRepository userRepository;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository, MedicalAppointmentRepository medicalAppointmentRepository, UserRepository userRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.medicalAppointmentRepository = medicalAppointmentRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }

    @Override
    public Prescription findById(UUID code) {
        return prescriptionRepository.findById(code)
                .orElseThrow(() -> new IllegalArgumentException("no encontrada"));
    }

    @Override
    public void savePrescription(SavePrescriptionDTO savePrescriptionDTO, UUID doctorId) {
        // Verify that the user is a doctor
        User doctor = userRepository.findById(doctorId).orElseThrow(() -> new IllegalArgumentException("Doctor not found"));
        boolean isDoctor = doctor.getRoles().stream().anyMatch(role -> role.getName().equals("DOCTOR"));
        if (!isDoctor) {
            throw new IllegalArgumentException("User is not a doctor");
        }

        // Find the medical appointment
        MedicalAppointment medicalAppointment = medicalAppointmentRepository.findById(savePrescriptionDTO.getMedicalAppointmentId())
                .orElseThrow(() -> new IllegalArgumentException("Medical appointment not found"));

        // Create and save the prescription
        Prescription prescription = new Prescription();
        prescription.setName(savePrescriptionDTO.getDetails());
        prescription.setMedical_appointment(medicalAppointment); // Set the medical appointment

        prescriptionRepository.save(prescription);
    }
}
