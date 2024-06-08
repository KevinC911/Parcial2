package com.parcial2.domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table
@Entity
public class MedicalAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID code;

    private LocalDateTime appointmentdate;

    @ManyToOne
    @JoinColumn(name = "user_code")
    private User user;

    @OneToMany(mappedBy = "medical_appointment")
    @JsonIgnore
    private List<Prescription> prescriptions;


}
