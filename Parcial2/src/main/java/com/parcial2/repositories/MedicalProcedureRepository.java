package com.parcial2.repositories;

import com.parcial2.domain.Entities.MedicalProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MedicalProcedureRepository extends JpaRepository<MedicalProcedure, String> {
    List<MedicalProcedure> findAllByCode(String code);
}
