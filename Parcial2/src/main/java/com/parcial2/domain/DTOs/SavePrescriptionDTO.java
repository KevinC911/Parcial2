package com.parcial2.domain.DTOs;

import java.util.UUID;

public class SavePrescriptionDTO {
    private String details;
    private UUID medicalAppointmentId;
    // Getters and Setters
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public UUID getMedicalAppointmentId() {
        return medicalAppointmentId;
    }

    public void setMedicalAppointmentId(UUID medicalAppointmentId) {
        this.medicalAppointmentId = medicalAppointmentId;
    }
}
