package com.parcial2.domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table
public class Speciality {
    @Id
    private String code;

    @OneToMany(mappedBy = "speciality")
    @JsonIgnore
    private List<MedicalProcedure> procedures;

    private String name;
}
