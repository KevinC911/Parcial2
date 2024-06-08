package com.parcial2.services.servicesImpl;

import com.parcial2.domain.Entities.Speciality;
import com.parcial2.repositories.SpecialityRepository;
import com.parcial2.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public void saveSpeciality(Speciality speciality) {
        specialityRepository.save(speciality);
    }

    @Override
    public List<Speciality> getAllSpecialities() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality getSpecialityByName(String name) {
        return specialityRepository.findByName(name);
    }
}
