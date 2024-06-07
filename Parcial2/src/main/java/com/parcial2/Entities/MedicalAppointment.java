package com.parcial2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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

    private LocalDate appointmentdate;

    @ManyToOne
    @JoinColumn(name = "user_code")
    private User user;

    @OneToMany(mappedBy = "medical_appointment")
    @JsonIgnore
    private Set<Prescription> prescriptions;

    @OneToMany(mappedBy = "medical_appointment")
    @JsonIgnore
    private Set<MedicalProcedure> procedures;

}
