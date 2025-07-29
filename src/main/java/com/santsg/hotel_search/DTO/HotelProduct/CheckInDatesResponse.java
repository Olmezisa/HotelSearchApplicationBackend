package com.santsg.hotel_search.DTO.HotelProduct;


import java.util.List;

import lombok.Data;

@Data
public class CheckInDatesResponse {
    private Body body;
    @Data
    public static class Body {
        private List<String> dates;
    }
}
