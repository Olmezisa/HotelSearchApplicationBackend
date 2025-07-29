package com.santsg.hotel_search.DTO.PriceSearch;

import lombok.Data;
import java.util.List;

import com.santsg.hotel_search.DTO.HotelProduct.Currency;

@Data
public class FrontendPriceSearchRequest {
    private String locationId;
    private int locationType; 
    private String checkIn;   
    private String checkOut;  
    private List<RoomCriterion> roomCriteria;
    private String nationality;
    private Currency currency;
    private String culture = "en-US";
}