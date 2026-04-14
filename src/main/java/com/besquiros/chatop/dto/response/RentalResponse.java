package com.besquiros.chatop.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record RentalResponse(
        Long id,
        String name,
        Integer surface,
        Integer price,
        String picture,
        String description,
        @JsonProperty("owner_id") Long ownerId,
        @JsonProperty("created_at") @JsonFormat(pattern = "yyyy/MM/dd") LocalDateTime createdAt,
        @JsonProperty("updated_at") @JsonFormat(pattern = "yyyy/MM/dd") LocalDateTime updatedAt
) {}
