package com.besquiros.chatop.controller;

import com.besquiros.chatop.dto.request.RentalRequest;
import com.besquiros.chatop.dto.response.MessageResponse;
import com.besquiros.chatop.dto.response.RentalResponse;
import com.besquiros.chatop.dto.response.RentalsResponse;
import com.besquiros.chatop.service.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MessageResponse> create(
            @Valid @ModelAttribute RentalRequest request,
            @RequestParam(required = false) MultipartFile picture,
            @AuthenticationPrincipal UserDetails userDetails) {
        rentalService.create(request, picture, userDetails.getUsername());
        return ResponseEntity.ok(new MessageResponse("Rental created !"));
    }

    @Operation(summary = "Update a rental")
    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> update(@PathVariable Long id, @Valid @ModelAttribute RentalRequest request) {
        rentalService.update(id, request);
        return ResponseEntity.ok(new MessageResponse("Rental updated !"));
    }
}
