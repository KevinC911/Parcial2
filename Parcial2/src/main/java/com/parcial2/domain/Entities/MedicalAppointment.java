package com.parcial2.domain.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table
@Entity
public class MedicalAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID code;

    private LocalDate appointmentdate;
}
