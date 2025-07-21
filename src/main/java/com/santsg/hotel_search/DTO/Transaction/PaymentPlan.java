package com.santsg.hotel_search.DTO.Transaction;

import lombok.Data;
@Data
public class PaymentPlan {
    private int paymentNo;
    private String dueDate;
    private Price price;
    private boolean paymentStatus;
}