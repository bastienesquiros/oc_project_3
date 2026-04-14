package com.besquiros.chatop.service;

import com.besquiros.chatop.dto.response.UserResponse;
import com.besquiros.chatop.exception.NotFoundException;
import com.besquiros.chatop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse findById(Long id) {
        return userRepository.findById(id)
                .map(AuthService::toUserResponse)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
