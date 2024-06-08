package com.parcial2.services;

import com.parcial2.domain.Entities.Speciality;

import java.util.List;

public interface SpecialityService {
    void saveSpeciality(Speciality speciality);
    List<Speciality> getAllSpecialities();
    Speciality getSpecialityByName(String name);
}
