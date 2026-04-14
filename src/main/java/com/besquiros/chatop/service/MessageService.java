package com.besquiros.chatop.service;

import com.besquiros.chatop.dto.request.MessageRequest;
import com.besquiros.chatop.mapper.MessageMapper;
import com.besquiros.chatop.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public void create(MessageRequest request) {
        messageRepository.save(messageMapper.toEntity(request));
    }
}
