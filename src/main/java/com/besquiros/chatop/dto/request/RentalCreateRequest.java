package com.besquiros.chatop.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RentalCreateRequest {
    private String name;
    private Integer surface;
    private Integer price;
    private String picture;
    private String description;

    @JsonProperty("owner_id")
    private Long ownerId;
}
