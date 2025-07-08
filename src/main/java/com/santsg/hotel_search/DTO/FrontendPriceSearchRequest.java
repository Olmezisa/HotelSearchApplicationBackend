package com.santsg.hotel_search.DTO;

import lombok.Data;
import java.util.List;

@Data
public class FrontendPriceSearchRequest {
    private String locationId;
    private int locationType; // 1: Konum, 2: Otel
    private String checkIn;   // Format: "yyyy-MM-dd"
    private String checkOut;  // Format: "yyyy-MM-dd"
    private List<RoomCriterion> roomCriteria;
    private String nationality;
    private Currency currency;
    private String culture = "en-US";
}