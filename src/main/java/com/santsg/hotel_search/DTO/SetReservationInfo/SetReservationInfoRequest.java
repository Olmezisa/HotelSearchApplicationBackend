package com.santsg.hotel_search.DTO.SetReservationInfo;

import lombok.Data;
import java.util.List;

@Data
public class SetReservationInfoRequest {
    private String transactionId;
    private List<TravellerInfo> travellers;
    private CustomerInfo customerInfo;
    private String reservationNote;
    private String agencyReservationNumber;
}
