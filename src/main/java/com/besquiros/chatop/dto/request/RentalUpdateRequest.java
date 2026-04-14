package com.besquiros.chatop.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RentalUpdateRequest {
    @NotBlank
    private String name;

    @NotNull
    @Positive
    private Integer surface;

    @NotNull
    @Positive
    private Integer price;

    @NotBlank
    private String description;
}
