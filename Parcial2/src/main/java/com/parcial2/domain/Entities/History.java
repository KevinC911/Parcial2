package com.parcial2.domain.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table
@NoArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID code;

    private String illness;

    @ManyToOne
    @JoinColumn(name = "user_code")
    private User user;

}
