package com.parcial2.controllers;

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
