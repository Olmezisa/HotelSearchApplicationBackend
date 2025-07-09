package com.santsg.hotel_search.DTO.ProductInfoResponse;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Facility {
    private String id;
    private String name;
    private String note;
    @JsonProperty("isPriced")
    private boolean isPriced;
    private boolean highlighted;
    private String unit;
}