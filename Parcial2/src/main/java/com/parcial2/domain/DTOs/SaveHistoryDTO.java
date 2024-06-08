package com.parcial2.domain.DTOs;

import java.util.UUID;

public class SaveHistoryDTO {
    private String illness;
    private UUID userCode;

    // Getters and Setters
    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public UUID getUserCode() {
        return userCode;
    }

    public void setUserCode(UUID userCode) {
        this.userCode = userCode;
    }
}
