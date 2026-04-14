package com.besquiros.chatop.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageRequest {

    @JsonProperty("user_id")
    private Long userId;

    private String message;

    @JsonProperty("rental_id")
    private Long rentalId;
}
