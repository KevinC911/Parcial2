package com.parcial2.controllers;

import com.parcial2.domain.DTOs.SaveMedicalAppointmentDTO;
import com.parcial2.domain.Entities.MedicalAppointment;
import com.parcial2.services.MedicalAppointmentService;
import com.parcial2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
public class MedicalAppointmentController {
    private final MedicalAppointmentService medicalAppointmentService;
    private final UserService userService;

    @Autowired
    public MedicalAppointmentController(MedicalAppointmentService medicalAppointmentService, UserService userService) {
        this.medicalAppointmentService = medicalAppointmentService;
        this.userService = userService;
    }

    //mostrar todas las citas
    @GetMapping("/all")
    public ResponseEntity<List<MedicalAppointment>> getAll(){
        return ResponseEntity.ok(medicalAppointmentService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<MedicalAppointment> createAppointment(@RequestBody SaveMedicalAppointmentDTO saveMedicalAppointmentDTO){
        medicalAppointmentService.SaveMedicalAppointment(saveMedicalAppointmentDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable UUID id) {
        medicalAppointmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<MedicalAppointment>> getAppointmentsByUser(@RequestParam(required = false) UUID userId,
                                                                          @RequestParam(required = false) String username) {
        List<MedicalAppointment> appointments;
        if (userId != null) {
            appointments = medicalAppointmentService.findByUserId(userId);
        } else if (username != null) {
            appointments = medicalAppointmentService.findByUsername(username);
        } else {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(appointments);
    }

}
