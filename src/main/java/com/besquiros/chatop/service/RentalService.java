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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RentalService {

    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;
    private final RentalMapper rentalMapper;

    private static final String UPLOAD_DIR = "uploads/";
    private static final String UPLOAD_URL = "http://localhost:8080/";

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

    public void create(RentalCreateRequest request, MultipartFile picture, String ownerEmail) {
        User owner = userRepository.findByEmail(ownerEmail)
                .orElseThrow(() -> new NotFoundException("Owner not found"));
        String picturePath = savePicture(picture);
        rentalRepository.save(rentalMapper.toEntity(request, owner, picturePath));
    }

    public void update(Long id, RentalUpdateRequest request) {
        Rental rental = rentalRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rental not found"));
        rentalMapper.applyUpdate(rental, request);
        rentalRepository.save(rental);
    }

    private String savePicture(MultipartFile file) {
        if (file == null || file.isEmpty()) return null;
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Files.copy(file.getInputStream(), uploadPath.resolve(filename));
            return UPLOAD_URL + UPLOAD_DIR + filename;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save picture", e);
        }
    }
}
