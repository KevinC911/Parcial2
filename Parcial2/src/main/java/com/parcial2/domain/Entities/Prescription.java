package com.parcial2.domain.Entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID code;

    private String name;

    @ManyToOne
    @JoinColumn(name = "medical_appointment_code")
    private MedicalAppointment medical_appointment;

    // Getters and Setters
    public UUID getId() {
        return code;
    }

    public void setId(UUID id) {
        this.code = code;
    }

    public String getDetails() {
        return name;
    }

    public void setDetails(String details) {
        this.name = details;
    }

    public MedicalAppointment getMedicalAppointment() {
        return medical_appointment;
    }

    public void setMedicalAppointment(MedicalAppointment medicalAppointment) {
        this.medical_appointment = medical_appointment;
    }
}
