package com.parcial2.repositories;

import com.parcial2.domain.Entities.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpecialityRepository extends JpaRepository<Speciality, UUID> {
    Speciality findByName(String name);
}
