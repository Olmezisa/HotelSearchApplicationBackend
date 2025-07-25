package com.santsg.hotel_search.DTO.HotelProductResponse;

import java.util.List;

import com.santsg.hotel_search.DTO.Nationality;

import lombok.Data;

@Data
public class NationalitiesResponse {
    
    private Body body;


    @Data
    public static class Body{
        private List<Nationality> nationalities;

    }

    
}
