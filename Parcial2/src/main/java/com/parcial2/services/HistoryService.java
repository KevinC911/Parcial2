package com.parcial2.services;

import com.parcial2.domain.Entities.History;

import java.util.List;
import java.util.UUID;

public interface HistoryService {
    List<History> findAll();
    History findById(UUID id);
    List<History> findByUserId(UUID userId);
    History save(History history);
    void deleteById(UUID id);
}
