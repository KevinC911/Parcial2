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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID code;

    private String username;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<History> medicalHistory;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="permissions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}
