package com.besquiros.chatop.service;

import com.besquiros.chatop.dto.request.RentalCreateRequest;
import com.besquiros.chatop.dto.response.RentalResponse;
import com.besquiros.chatop.dto.request.RentalUpdateRequest;
import com.besquiros.chatop.dto.response.RentalsResponse;
import com.besquiros.chatop.entity.Rental;
import com.besquiros.chatop.exception.NotFoundException;
import com.besquiros.chatop.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalsResponse findAll() {
        List<RentalResponse> rentals = rentalRepository.findAll()
                .stream()
                .map(this::toRentalResponse)
                .toList();
        return new RentalsResponse(rentals);
    }

    public RentalResponse findById(Long id) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rental not found"));
        return toRentalResponse(rental);
    }

    public void create(RentalCreateRequest request) {
        Rental rental = new Rental();
        rental.setName(request.getName());
        rental.setSurface(request.getSurface());
        rental.setPrice(request.getPrice());
        rental.setPicture(request.getPicture());
        rental.setDescription(request.getDescription());
        rental.setOwnerId(request.getOwnerId());
        rentalRepository.save(rental);
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

    private RentalResponse toRentalResponse(Rental rental) {
        RentalResponse response = new RentalResponse();
        response.setId(rental.getId());
        response.setName(rental.getName());
        response.setSurface(rental.getSurface());
        response.setPrice(rental.getPrice());
        response.setPicture(rental.getPicture());
        response.setDescription(rental.getDescription());
        response.setOwnerId(rental.getOwnerId());
        response.setCreatedAt(rental.getCreatedAt());
        response.setUpdatedAt(rental.getUpdatedAt());
        return response;
    }
}
