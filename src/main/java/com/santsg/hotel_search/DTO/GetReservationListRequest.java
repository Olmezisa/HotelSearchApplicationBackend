package com.santsg.hotel_search.DTO;

import lombok.Data;
import java.util.List;


@Data
public class GetReservationListRequest {
    private String culture;
    private List<DateCriteria> dateCriterias;
   
    @Data
    public static class DateCriteria {
        private int type; 
        private String from; 
        private String to;  
    }
}