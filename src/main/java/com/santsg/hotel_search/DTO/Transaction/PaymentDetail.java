package com.santsg.hotel_search.DTO.Transaction;

import lombok.Data;
import java.util.List;
@Data
public class PaymentDetail {
    private List<PaymentPlan> paymentPlan;
    private List<Object> paymentInfo;
}