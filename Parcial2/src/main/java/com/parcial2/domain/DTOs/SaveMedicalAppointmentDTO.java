package com.parcial2.domain.DTOs;

import java.time.LocalDateTime;
import java.util.UUID;

public class SaveMedicalAppointmentDTO {
    private LocalDateTime appointmentDate;
    private UUID userId;

    // Getters and Setters
    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {

        this.appointmentDate = appointmentDate;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
