package com.besquiros.chatop.mapper;

import com.besquiros.chatop.dto.request.RentalRequest;
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

    public Rental toEntity(RentalRequest request, User owner, String picturePath) {
        Rental rental = new Rental();
        rental.setName(request.getName());
        rental.setSurface(request.getSurface());
        rental.setPrice(request.getPrice());
        rental.setPicture(picturePath);
        rental.setDescription(request.getDescription());
        rental.setOwner(owner);
        return rental;
    }

    public void applyUpdate(Rental rental, RentalRequest request) {
        rental.setName(request.getName());
        rental.setSurface(request.getSurface());
        rental.setPrice(request.getPrice());
        rental.setDescription(request.getDescription());
    }
}
