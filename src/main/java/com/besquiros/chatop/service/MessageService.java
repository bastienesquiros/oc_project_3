package com.besquiros.chatop.service;

import com.besquiros.chatop.dto.request.MessageRequest;
import com.besquiros.chatop.entity.Rental;
import com.besquiros.chatop.entity.User;
import com.besquiros.chatop.exception.NotFoundException;
import com.besquiros.chatop.mapper.MessageMapper;
import com.besquiros.chatop.repository.MessageRepository;
import com.besquiros.chatop.repository.RentalRepository;
import com.besquiros.chatop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final RentalRepository rentalRepository;
    private final MessageMapper messageMapper;

    public void create(MessageRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new NotFoundException("User not found"));
        Rental rental = rentalRepository.findById(request.getRentalId())
                .orElseThrow(() -> new NotFoundException("Rental not found"));
        messageRepository.save(messageMapper.toEntity(request, user, rental));
    }
}
