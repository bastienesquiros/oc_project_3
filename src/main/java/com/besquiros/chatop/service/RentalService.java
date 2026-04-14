package com.besquiros.chatop.service;

import com.besquiros.chatop.dto.request.RentalCreateRequest;
import com.besquiros.chatop.dto.request.RentalUpdateRequest;
import com.besquiros.chatop.dto.response.RentalResponse;
import com.besquiros.chatop.dto.response.RentalsResponse;
import com.besquiros.chatop.entity.Rental;
import com.besquiros.chatop.entity.User;
import com.besquiros.chatop.exception.NotFoundException;
import com.besquiros.chatop.mapper.RentalMapper;
import com.besquiros.chatop.repository.RentalRepository;
import com.besquiros.chatop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;
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
        User owner = userRepository.findById(request.getOwnerId())
                .orElseThrow(() -> new NotFoundException("Owner not found"));
        rentalRepository.save(rentalMapper.toEntity(request, owner));
    }

    public void update(Long id, RentalUpdateRequest request) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rental not found"));
        rentalMapper.applyUpdate(rental, request);
        rentalRepository.save(rental);
    }
}
