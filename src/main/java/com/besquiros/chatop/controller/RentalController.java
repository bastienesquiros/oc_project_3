package com.besquiros.chatop.controller;

import com.besquiros.chatop.dto.response.MessageResponse;
import com.besquiros.chatop.dto.request.RentalCreateRequest;
import com.besquiros.chatop.dto.response.RentalResponse;
import com.besquiros.chatop.dto.request.RentalUpdateRequest;
import com.besquiros.chatop.dto.response.RentalsResponse;
import com.besquiros.chatop.service.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
@Tag(name = "Rentals")
public class RentalController {

    private final RentalService rentalService;

    @Operation(summary = "Get all rentals")
    @GetMapping
    public ResponseEntity<RentalsResponse> getAll() {
        return ResponseEntity.ok(rentalService.findAll());
    }

    @Operation(summary = "Get rental by id")
    @GetMapping("/{id}")
    public ResponseEntity<RentalResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.findById(id));
    }

    @Operation(summary = "Create a rental")
    @PostMapping
    public ResponseEntity<MessageResponse> create(@Valid @RequestBody RentalCreateRequest request) {
        rentalService.create(request);
        return ResponseEntity.ok(new MessageResponse("Rental created !"));
    }

    @Operation(summary = "Update a rental")
    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> update(@PathVariable Long id, @Valid @RequestBody RentalUpdateRequest request) {
        rentalService.update(id, request);
        return ResponseEntity.ok(new MessageResponse("Rental updated !"));
    }
}
