package com.besquiros.chatop.controller;

import com.besquiros.chatop.dto.response.MessageResponse;
import com.besquiros.chatop.dto.request.RentalCreateRequest;
import com.besquiros.chatop.dto.response.RentalResponse;
import com.besquiros.chatop.dto.request.RentalUpdateRequest;
import com.besquiros.chatop.dto.response.RentalsResponse;
import com.besquiros.chatop.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
public class RentalController {

    private final RentalService rentalService;

    @GetMapping
    public ResponseEntity<RentalsResponse> getAll() {
        return ResponseEntity.ok(rentalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody RentalCreateRequest request) {
        rentalService.create(request);
        return ResponseEntity.ok(new MessageResponse("Rental created !"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> update(@PathVariable Long id, @RequestBody RentalUpdateRequest request) {
        rentalService.update(id, request);
        return ResponseEntity.ok(new MessageResponse("Rental updated !"));
    }
}
