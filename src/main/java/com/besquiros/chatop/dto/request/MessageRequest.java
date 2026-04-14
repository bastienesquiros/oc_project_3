package com.besquiros.chatop.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessageRequest {

    @NotNull
    private Long userId;

    @NotBlank
    private String message;

    @NotNull
    private Long rentalId;
}
