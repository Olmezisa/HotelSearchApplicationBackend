package com.santsg.hotel_search.DTO.HotelProduct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArrivalAutocompleteRequest {
    @JsonProperty("ProductType")
    private int productType;

    @JsonProperty("Query")
    private String query;

    @JsonProperty("Culture")
    private String culture;
}