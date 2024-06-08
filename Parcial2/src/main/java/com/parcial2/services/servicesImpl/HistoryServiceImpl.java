package com.parcial2.services.servicesImpl;

import com.parcial2.domain.Entities.History;
import com.parcial2.repositories.HistoryRepository;
import com.parcial2.services.HistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<History> findAll() {
        return historyRepository.findAll();
    }

    @Override
    public History findById(UUID id) {
        return historyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("History not found"));
    }

    @Override
    public List<History> findByUserId(UUID userId) {
        return historyRepository.findByUserCode(userId);
    }

    @Override
    public History save(History history) {
        return historyRepository.save(history);
    }

    @Override
    public void deleteById(UUID id) {
        historyRepository.deleteById(id);
    }
}
