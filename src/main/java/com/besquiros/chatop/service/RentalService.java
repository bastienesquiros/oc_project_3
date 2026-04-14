package com.besquiros.chatop.service;

import com.besquiros.chatop.dto.request.RentalCreateRequest;
import com.besquiros.chatop.dto.response.RentalResponse;
import com.besquiros.chatop.dto.request.RentalUpdateRequest;
import com.besquiros.chatop.dto.response.RentalsResponse;
import com.besquiros.chatop.entity.Rental;
import com.besquiros.chatop.exception.NotFoundException;
import com.besquiros.chatop.mapper.RentalMapper;
import com.besquiros.chatop.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;

    public RentalsResponse findAll() {
        List<RentalResponse> rentals = rentalRepository.findAll()
                .stream()
                .map(rentalMapper::toResponse)
                .toList();
        return new RentalsResponse(rentals);
    }

    public RentalResponse findById(Long id) {
        return rentalRepository.findById(id)
                .map(rentalMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("Rental not found"));
    }

    public void create(RentalCreateRequest request) {
        rentalRepository.save(rentalMapper.toEntity(request));
    }

    public void update(Long id, RentalUpdateRequest request) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rental not found"));
        if (request.getName() != null) rental.setName(request.getName());
        if (request.getSurface() != null) rental.setSurface(request.getSurface());
        if (request.getPrice() != null) rental.setPrice(request.getPrice());
        if (request.getDescription() != null) rental.setDescription(request.getDescription());
        rentalRepository.save(rental);
    }
}
