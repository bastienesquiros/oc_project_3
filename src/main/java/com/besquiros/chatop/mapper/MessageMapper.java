package com.besquiros.chatop.mapper;

import com.besquiros.chatop.dto.request.MessageRequest;
import com.besquiros.chatop.entity.Message;
import com.besquiros.chatop.entity.Rental;
import com.besquiros.chatop.entity.User;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    public Message toEntity(MessageRequest request, User user, Rental rental) {
        Message message = new Message();
        message.setUser(user);
        message.setRental(rental);
        message.setMessage(request.getMessage());
        return message;
    }
}
