package com.parcial2.services.servicesImpl;

import com.parcial2.domain.DTOs.SaveMedicalAppointmentDTO;
import com.parcial2.domain.Entities.MedicalAppointment;
import com.parcial2.domain.Entities.User;
import com.parcial2.repositories.MedicalAppointmentRepository;
import com.parcial2.repositories.UserRepository;
import com.parcial2.services.MedicalAppointmentService;
import com.parcial2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicalAppointmentServiceImpl implements MedicalAppointmentService {

    private final MedicalAppointmentRepository medicalAppointmentRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public MedicalAppointmentServiceImpl(MedicalAppointmentRepository medicalAppointmentRepository, UserService userService, UserService userService1, UserRepository userRepository) {
        this.medicalAppointmentRepository = medicalAppointmentRepository;
        this.userService = userService1;
        this.userRepository = userRepository;
    }

    @Override
    public List<MedicalAppointment> findAll() {
        return medicalAppointmentRepository.findAll();
    }

    @Override
    public void SaveMedicalAppointment(SaveMedicalAppointmentDTO info) {
        // Load the user from the database
        User user = userService.findById(info.getUserId()).orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Create a new MedicalAppointment object
        MedicalAppointment medicalAppointment = new MedicalAppointment();
        medicalAppointment.setAppointmentdate(info.getAppointmentDate());
        medicalAppointment.setUser(user);

        medicalAppointmentRepository.save(medicalAppointment);
    }

    @Override
    public void deleteById(UUID id) {
        medicalAppointmentRepository.deleteById(id);
    }

    @Override
    public List<MedicalAppointment> findByUserId(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return medicalAppointmentRepository.findByUser(user);
    }

    @Override
    public List<MedicalAppointment> findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return medicalAppointmentRepository.findByUser(user);
    }


}
