package com.besquiros.chatop.mapper;

import com.besquiros.chatop.dto.response.UserResponse;
import com.besquiros.chatop.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
