package com.besquiros.chatop.mapper;

import com.besquiros.chatop.dto.request.MessageRequest;
import com.besquiros.chatop.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public Message toEntity(MessageRequest request) {
        Message message = new Message();
        message.setUserId(request.getUserId());
        message.setRentalId(request.getRentalId());
        message.setMessage(request.getMessage());
        return message;
    }
}
