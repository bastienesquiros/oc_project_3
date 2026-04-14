package com.besquiros.chatop.repository;

import com.besquiros.chatop.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
