package com.parcial2.controllers;

import com.parcial2.domain.DTOs.SavePrescriptionDTO;
import com.parcial2.domain.Entities.Prescription;
import com.parcial2.services.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        return ResponseEntity.ok(prescriptionService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable UUID id) {
        Prescription prescription = prescriptionService.findById(id);
        return ResponseEntity.ok(prescription);
    }
    @PostMapping("/create")
    public ResponseEntity<Void> createPrescription(@RequestBody SavePrescriptionDTO savePrescriptionDTO,
                                                   @RequestHeader("Doctor-ID") String doctorId) {
        UUID doctorUUID;
        try {
            doctorUUID = UUID.fromString(doctorId);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID string: " + doctorId);
        }
        prescriptionService.savePrescription(savePrescriptionDTO, doctorUUID);
        return ResponseEntity.ok().build();
    }
}
