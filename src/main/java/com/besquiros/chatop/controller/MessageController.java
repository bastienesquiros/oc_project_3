package com.besquiros.chatop.controller;

import com.besquiros.chatop.dto.request.MessageRequest;
import com.besquiros.chatop.dto.response.MessageResponse;
import com.besquiros.chatop.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
@Tag(name = "Messages")
public class MessageController {

    private final MessageService messageService;

    @Operation(summary = "Send a message")
    @PostMapping
    public ResponseEntity<MessageResponse> sendMessage(@Valid @RequestBody MessageRequest request) {
        messageService.create(request);
        return ResponseEntity.ok(new MessageResponse("Message send with success"));
    }
}
