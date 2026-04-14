package com.besquiros.chatop.controller;

import com.besquiros.chatop.dto.request.MessageRequest;
import com.besquiros.chatop.dto.response.MessageResponse;
import com.besquiros.chatop.service.MessageService;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<MessageResponse> sendMessage(@Valid @RequestBody MessageRequest request) {
        messageService.create(request);
        return ResponseEntity.ok(new MessageResponse("Message send with success"));
    }
}
