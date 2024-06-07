package com.parcial2.domain.DTOs;

import com.parcial2.domain.Entities.Token;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TokenDTO {

    private String token;
    public TokenDTO(Token token) {
        this.token = token.getContent();
    }
}
