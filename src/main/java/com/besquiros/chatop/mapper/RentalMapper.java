package com.besquiros.chatop.mapper;

import com.besquiros.chatop.dto.request.RentalCreateRequest;
import com.besquiros.chatop.dto.response.RentalResponse;
import com.besquiros.chatop.entity.Rental;
import org.springframework.stereotype.Component;

@Component
public class RentalMapper {

    public RentalResponse toResponse(Rental rental) {
        return new RentalResponse(
                rental.getId(),
                rental.getName(),
                rental.getSurface(),
                rental.getPrice(),
                rental.getPicture(),
                rental.getDescription(),
                rental.getOwnerId(),
                rental.getCreatedAt(),
                rental.getUpdatedAt()
        );
    }

    public Rental toEntity(RentalCreateRequest request) {
        Rental rental = new Rental();
        rental.setName(request.getName());
        rental.setSurface(request.getSurface());
        rental.setPrice(request.getPrice());
        rental.setPicture(request.getPicture());
        rental.setDescription(request.getDescription());
        rental.setOwnerId(request.getOwnerId());
        return rental;
    }
}
