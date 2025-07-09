package com.santsg.hotel_search.DTO.ProductInfoResponse;

import lombok.Data;

@Data
public class PaymentPlanInfo {
    private int id;
    private int phase;
    private int day;
    private int paymentTimeStatus;
    private PaymentPrice price;
}