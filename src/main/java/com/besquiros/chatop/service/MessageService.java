package com.besquiros.chatop.service;

import com.besquiros.chatop.dto.request.MessageRequest;
import com.besquiros.chatop.entity.Message;
import com.besquiros.chatop.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public void create(MessageRequest request) {
        Message message = new Message();
        message.setUserId(request.getUserId());
        message.setRentalId(request.getRentalId());
        message.setMessage(request.getMessage());
        messageRepository.save(message);
    }
}
