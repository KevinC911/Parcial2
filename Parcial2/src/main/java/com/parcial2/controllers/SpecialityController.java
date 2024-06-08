package com.parcial2.controllers;

import com.parcial2.domain.DTOs.AddSpecialityDTO;
import com.parcial2.domain.Entities.Speciality;
import com.parcial2.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/speciality")
public class SpecialityController {

    private final SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createSpeciality(@RequestBody AddSpecialityDTO speciality) {
        Speciality newSpeciality = new Speciality();
        newSpeciality.setName(speciality.getName());
        newSpeciality.setCode(newSpeciality.getCode());
        specialityService.saveSpeciality(newSpeciality);
        return new ResponseEntity<>("Speciality created", HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllSpecialities() {
        return new ResponseEntity<>(specialityService.getAllSpecialities(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getSpecialityByName(@PathVariable String name) {
        return new ResponseEntity<>(specialityService.getSpecialityByName(name), HttpStatus.OK);
    }
}
