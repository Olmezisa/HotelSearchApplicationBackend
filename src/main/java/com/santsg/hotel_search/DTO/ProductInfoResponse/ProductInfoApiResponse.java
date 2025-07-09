package com.santsg.hotel_search.DTO.ProductInfoResponse;

import lombok.Data;

@Data
public class ProductInfoApiResponse {
    private Body body;


    @Data
    public static class Body{
        private HotelInfo hotel;
    }

}