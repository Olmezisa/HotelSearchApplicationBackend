package com.santsg.hotel_search.DTO.HotelProduct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;


@Data
public class CheckInDatesRequest {
    @JsonProperty("ProductType")
    private int productType;

    @JsonProperty("IncludeSubLocations")
    private boolean includeSubLocations;

    @JsonProperty("Product")
    private String product; 

    @JsonProperty("ArrivalLocations")
    private List<ArrivalLocation> arrivalLocations;
}