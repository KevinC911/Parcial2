package com.parcial2.repositories;

import com.parcial2.domain.Entities.MedicalAppointment;
import com.parcial2.domain.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, UUID> {
    //cosas como buscar una cita medica en especifico
    List<MedicalAppointment> findByUser(User user);
}
