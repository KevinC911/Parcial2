package com.parcial2.services;
import com.parcial2.domain.Entities.Token;
import com.parcial2.domain.Entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.parcial2.domain.DTOs.UserRegisterDTO;
import com.parcial2.domain.Entities.User;
import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUsername(String username);
    User saveUser(User user);

    // Token management
    Token registerToken(User user) throws Exception;
    Boolean isTokenValid(User user, String token);
    void cleanTokens(User user) throws Exception;
}