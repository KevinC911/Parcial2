package com.parcial2.controllers;


import com.parcial2.domain.DTOs.TokenDTO;
import com.parcial2.domain.DTOs.UserLoginDTO;
import com.parcial2.domain.DTOs.UserRegisterDTO;
import com.parcial2.domain.Entities.Token;
import com.parcial2.domain.Entities.User;
import com.parcial2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@ModelAttribute UserLoginDTO info, BindingResult validations){

        User user = userService.findUserByIdentifier(info.getIdentifier());

        try {
            Token token = userService.registerToken(user);
            return new ResponseEntity<>(new TokenDTO(token), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@ModelAttribute UserRegisterDTO info, BindingResult validations){
        userService.saveUser(info);
        return new ResponseEntity<>("registered", HttpStatus.OK);
    }

}
