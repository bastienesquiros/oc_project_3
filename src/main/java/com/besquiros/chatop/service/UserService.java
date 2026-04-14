package com.besquiros.chatop.service;

import com.besquiros.chatop.dto.response.UserResponse;
import com.besquiros.chatop.exception.NotFoundException;
import com.besquiros.chatop.mapper.UserMapper;
import com.besquiros.chatop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // TODO: En fait à quoi sert méthode ? On pourrait pas la remplacer par un /me dans le front ? A voir
    public UserResponse findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toResponse)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
