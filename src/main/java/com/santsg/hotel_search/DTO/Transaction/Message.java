package com.santsg.hotel_search.DTO.Transaction;

import lombok.Data;
@Data
public class Message {
    private int id;
    private String code;
    private int messageType;
    private String message;
}