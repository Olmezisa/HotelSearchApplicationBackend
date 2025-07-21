package com.santsg.hotel_search.DTO.Transaction;

import lombok.Data;

@Data
public class ReservationInfo {
    private String bookingNumber;
    private String beginDate;
    private String endDate;
    private Price salePrice;
    private Price agencyAmountToPay;
    private Price passengerAmountToPay;
    private Price totalPrice;
    private AgencyCommission agencyCommission;
    private int reservationStatus;
    private int confirmationStatus;
    private int paymentStatus;
}