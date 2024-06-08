package com.parcial2.repositories;

import com.parcial2.domain.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String username);

}
