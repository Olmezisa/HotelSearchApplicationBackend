package com.santsg.hotel_search.DTO.Reservation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class GetReservationDetailRequest {
    @JsonProperty("ReservationNumber")
    private String reservationNumber;
}
