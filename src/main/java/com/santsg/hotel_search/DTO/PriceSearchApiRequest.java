package com.santsg.hotel_search.DTO;

import lombok.Data;
import java.util.List;

@Data
public class PriceSearchApiRequest {
    private String locationId;
    private int locationType; 
    private String checkIn;   
    private String checkOut;  
    private List<RoomCriterion> roomCriteria;
    private String nationality;
    private Currency currency;
    private String culture = "en-US";
}