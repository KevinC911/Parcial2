package com.parcial2.domain.Entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table
public class MedicalProcedure {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID code;

    @ManyToOne
    @JoinColumn(name = "user_code")
    private User user;

    @ManyToOne
    @JoinColumn(name = "medical_appointment_code")
    private MedicalAppointment medical_appointment;

    @ManyToOne
    @JoinColumn(name = "speciality_code")
    private Speciality speciality;
}
