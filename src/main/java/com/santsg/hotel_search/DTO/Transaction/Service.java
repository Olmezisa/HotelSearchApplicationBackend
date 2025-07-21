package com.santsg.hotel_search.DTO.Transaction;
import lombok.Data;
@Data
public class Service {
    private String id;
    private int type;
    private Price price;
    private int passengerType;
}