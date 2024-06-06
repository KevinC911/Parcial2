package com.parcial2.Entities;

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
}
