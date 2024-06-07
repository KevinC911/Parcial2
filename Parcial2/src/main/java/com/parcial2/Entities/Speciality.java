package com.parcial2.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID code;

    @OneToMany(mappedBy = "speciality")
    @JsonIgnore
    private Set<MedicalProcedure> procedures;

    private String name;
}
