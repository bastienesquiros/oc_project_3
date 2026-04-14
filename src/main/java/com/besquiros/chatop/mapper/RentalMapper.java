package com.besquiros.chatop.mapper;

import com.besquiros.chatop.dto.request.RentalCreateRequest;
import com.besquiros.chatop.dto.response.RentalResponse;
import com.besquiros.chatop.entity.Rental;
import com.besquiros.chatop.entity.User;
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
                rental.getOwner().getId(),
                rental.getCreatedAt(),
                rental.getUpdatedAt()
        );
    }

    public Rental toEntity(RentalCreateRequest request, User owner) {
        Rental rental = new Rental();
        rental.setName(request.getName());
        rental.setSurface(request.getSurface());
        rental.setPrice(request.getPrice());
        rental.setPicture(request.getPicture());
        rental.setDescription(request.getDescription());
        rental.setOwner(owner);
        return rental;
    }
}
