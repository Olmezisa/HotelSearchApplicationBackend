package com.santsg.hotel_search.DTO.Transaction;

import lombok.Data;
@Data
public class AgencyCommission {
    private int percent;
    private int amount;
    private String currency;
}