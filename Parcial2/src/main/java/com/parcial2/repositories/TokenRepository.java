package com.parcial2.repositories;

import com.parcial2.domain.Entities.Token;
import com.parcial2.domain.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {

    List<Token> findByUserAndActive(User user, Boolean active);
}
