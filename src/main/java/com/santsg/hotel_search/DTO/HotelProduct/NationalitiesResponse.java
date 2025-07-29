package com.santsg.hotel_search.DTO.HotelProduct;

import java.util.List;

import lombok.Data;

@Data
public class NationalitiesResponse {
    
    private Body body;


    @Data
    public static class Body{
        private List<Nationality> nationalities;

    }

    
}
