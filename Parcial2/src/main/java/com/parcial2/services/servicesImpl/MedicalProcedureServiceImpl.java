package com.parcial2.services.servicesImpl;

import com.parcial2.domain.Entities.MedicalAppointment;
import com.parcial2.domain.Entities.MedicalProcedure;
import com.parcial2.domain.Entities.Speciality;
import com.parcial2.domain.Entities.User;
import com.parcial2.repositories.MedicalProcedureRepository;
import com.parcial2.services.MedicalProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalProcedureServiceImpl implements MedicalProcedureService {

    @Autowired
    private MedicalProcedureRepository medicalProcedureRepository;
    @Override
    public void addMedicalProcedures(String code, List<User> doctors, List<Speciality> specialities, MedicalAppointment medAppointment) {
        int number = doctors.size();
        for(User user : doctors){

        }
    }

    @Override
    public void addMedicalProcedure(String code, User doctor, Speciality speciality, MedicalAppointment medAppointment) {
        MedicalProcedure proc =  new MedicalProcedure();
        proc.setCode(code);
        proc.setMedical_appointment(medAppointment);
        proc.setSpeciality(speciality);
        proc.setUser(doctor);
        medicalProcedureRepository.save(proc);
    }

    @Override
    public List<MedicalProcedure> getAllByCode(String code) {
        return medicalProcedureRepository.findAllByCode(code);
    }
}
