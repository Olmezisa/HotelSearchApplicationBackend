package com.santsg.hotel_search.DTO.Transaction;
import lombok.Data;
import java.util.List;
@Data
public class Header {
    private String requestId;
    private boolean success;
    private String responseTime;
    private List<Message> messages;
}