package com.parcial2.controllers;

import com.parcial2.domain.DTOs.SaveHistoryDTO;
import com.parcial2.domain.Entities.History;
import com.parcial2.domain.Entities.User;
import com.parcial2.services.HistoryService;
import com.parcial2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/histories")
public class HistoryController {
    private final HistoryService historyService;
    private final UserService userService;

    @Autowired
    public HistoryController(HistoryService historyService, UserService userService) {
        this.historyService = historyService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<History>> getAllHistories() {
        return ResponseEntity.ok(historyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<History> getHistoryById(@PathVariable UUID id) {
        History history = historyService.findById(id);
        return ResponseEntity.ok(history);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<History>> getHistoriesByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(historyService.findByUserId(userId));
    }

    @PostMapping( "/create")
    public ResponseEntity<History> createHistory(@RequestBody SaveHistoryDTO saveHistoryDTO) {
        // Verify user exists
        UUID userId = saveHistoryDTO.getUserCode();
        if (userId == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<User> userOptional = userService.findById(userId);
        if (!userOptional.isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }
        User user = userOptional.get();

        // Create History entity
        History history = new History();
        history.setIllness(saveHistoryDTO.getIllness());
        history.setUser(user);

        // Save History entity
        History savedHistory = historyService.save(history);
        return ResponseEntity.ok(savedHistory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistory(@PathVariable UUID id) {
        historyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
