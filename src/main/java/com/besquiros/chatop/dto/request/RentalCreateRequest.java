package com.besquiros.chatop.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RentalCreateRequest {
    @NotBlank
    private String name;

    @NotNull
    @Positive
    private Integer surface;

    @NotNull
    @Positive
    private Integer price;

    private String picture;

    @NotBlank
    private String description;

    @NotNull
    private Long ownerId;
}
