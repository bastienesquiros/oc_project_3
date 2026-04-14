package com.besquiros.chatop.dto.request;

import lombok.Data;

@Data
public class RentalUpdateRequest {
    private String name;
    private Integer surface;
    private Integer price;
    private String description;
}
