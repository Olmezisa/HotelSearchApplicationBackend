package com.santsg.hotel_search.DTO.PriceSearch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GiataInfo {

    @JsonProperty("hotelId")
    private String hotelId;

    @JsonProperty("destinationId")
    private String destinationId;
}