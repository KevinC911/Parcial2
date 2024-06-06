package com.parcial2.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table
public class Role {
    @Id
    private String role;

    private String name;

    @ManyToMany(mappedBy = "roles")
    List<User> users;

}
