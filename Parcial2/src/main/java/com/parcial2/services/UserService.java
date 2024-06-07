package com.parcial2.services;

import com.parcial2.domain.DTOs.UserRegisterDTO;
import com.parcial2.domain.Entities.User;

import java.util.List;

public interface UserService {
    void create(UserRegisterDTO info);
    User finByUsernameOrEmail(String username, String email);




    //listar todos lod usuarios
    List<User> findAll();
}
