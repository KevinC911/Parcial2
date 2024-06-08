package com.parcial2.domain.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table
@NoArgsConstructor
//propiedad específica del objeto como un identificador, que Jackson puede utilizar para evitar la serialización infinita en el caso de referencias circulares.
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "code")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID code;

    private String illness;

    @ManyToOne
    @JoinColumn(name = "user_code", nullable = false)
    private User user;

}
