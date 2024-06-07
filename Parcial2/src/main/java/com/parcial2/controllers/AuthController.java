package com.parcial2.controllers;

import com.parcial2.domain.DTOs.TokenDTO;
import com.parcial2.domain.Entities.Token;
import com.parcial2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.parcial2.domain.DTOs.GeneralResponse;
import com.parcial2.domain.DTOs.UserRegisterDTO;
import com.parcial2.domain.Entities.User;
import com.parcial2.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
  
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@ModelAttribute @Valid UserLoginDTO info, BindingResult validations){
        try {
            Token token = userService.registerToken(user);
            return new ResponseEntity<>(new TokenDTO(token), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
    @PostMapping("/register")
    public ResponseEntity<GeneralResponse> register(@RequestBody @Valid UserRegisterDTO info){
        User user = userService.finByUsernameOrEmail(info.getUsername(), info.getEmail());
        if(user != null){
            return GeneralResponse.getResponse(HttpStatus.CONFLICT, "Usuario ya existe");
        }
        userService.create(info);
        return GeneralResponse.getResponse(HttpStatus.CREATED, "Usuario creado exitosamente");
    }
}
