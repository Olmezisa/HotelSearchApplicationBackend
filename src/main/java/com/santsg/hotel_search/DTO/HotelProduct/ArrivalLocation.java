package com.santsg.hotel_search.DTO.HotelProduct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArrivalLocation {
    @JsonProperty("Id")
    private String id;

    @JsonProperty("Type")
    private int type;
}