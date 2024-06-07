package com.parcial2.services.impls;

import com.parcial2.domain.DTOs.UserRegisterDTO;
import com.parcial2.domain.Entities.User;
import com.parcial2.repositories.UserRepository;
import com.parcial2.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl( UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void create(UserRegisterDTO info) {
        User user = new User();
        user.setUsername(info.getUsername());
        user.setPassword(passwordEncoder.encode(info.getPassword()));
        user.setEmail(info.getEmail());
        userRepository.save(user);
    }

    @Override
    public User finByUsernameOrEmail(String username, String email) {
        return userRepository.findByUsernameOrEmail(username, email).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
