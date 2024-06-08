package com.parcial2.controllers;

import com.parcial2.domain.DTOs.AddMedicProcDTO;
import com.parcial2.domain.DTOs.AddMedicProcedureDTO;
import com.parcial2.domain.DTOs.GeneralResponse;
import com.parcial2.domain.DTOs.MedicalProcedureParsedDTO;
import com.parcial2.domain.Entities.MedicalProcedure;
import com.parcial2.domain.Entities.Speciality;
import com.parcial2.domain.Entities.User;
import com.parcial2.services.MedicalProcedureService;
import com.parcial2.services.SpecialityService;
import com.parcial2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicalprocedure")
public class MedicalProcedureController {

    private final SpecialityService specialityService;

    private final MedicalProcedureService medicalProcedureService;

    private final UserService userService;

    public MedicalProcedureController(MedicalProcedureService medicalProcedureService, SpecialityService specialityService, UserService userService) {
        this.medicalProcedureService = medicalProcedureService;
        this.specialityService = specialityService;
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveMedicalProcedure(@RequestBody AddMedicProcedureDTO info){
        Speciality speciality = specialityService.getSpecialityByName(info.getSpeciality());
        // MedicalAppointment appointment = medicalAppointmentService.getMedicalAppointmentByCode(info.getCode());
        User doctor = userService.findUserByIdentifier(info.getDoctor_identifier());

        // medicalProcedureService.addMedicalProcedure(info.getCode(), speciality, appointment, doctor);


        return new ResponseEntity<>("Medical procedure saved!", HttpStatus.CREATED);
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<?> getMedicalProceduresByCode(@RequestParam String code){
        List<MedicalProcedure> procedures = medicalProcedureService.getAllByCode(code);
        if(procedures.isEmpty()){
            return new ResponseEntity<>("Medical procedure not found!", HttpStatus.NOT_FOUND);
        }

        MedicalProcedureParsedDTO info = new MedicalProcedureParsedDTO();
        info.setCode(code);
        info.setAppointment(procedures.get(0).getMedical_appointment());

        for(int i = 0; i < procedures.size(); i++){
            info.addDoctor(procedures.get(i).getUser().getUsername());
            info.addSpeciality(procedures.get(i).getSpeciality().getName());
        }

        return new ResponseEntity<>(info, HttpStatus.OK);
    }

}
