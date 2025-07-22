package com.santsg.hotel_search.DTO.Transaction;

import lombok.Data;
import java.util.List;

@Data
public class ReservationData {
    private List<Traveller> travellers;
    private ReservationInfo reservationInfo;
    private List<Service> services;
    private PaymentDetail paymentDetail;
    private List<Object> invoices; 
}