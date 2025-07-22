package com.santsg.hotel_search.DTO;

import lombok.Data;
import java.util.List;


@Data
public class GetReservationListRequest {
    private String culture;
    private List<DateCriteria> dateCriterias;
    private int reservationStatus;
    private int limit;
    private int pageRowCount;
    private int maxIndexNumber;
    private int minIndexNumber;

   
    @Data
    public static class DateCriteria {
        private int type; 
        private String from; 
        private String to;  
    }
}