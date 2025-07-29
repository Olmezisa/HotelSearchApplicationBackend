package com.santsg.hotel_search.Common;

import java.util.List;


import lombok.Data;

@Data
public class Header {
        private String requestId;
        private boolean success;
        private String responseTime;
        private List<Message> messages;

@Data
    public static class Message {
        private int id;
        private String code;
        private int messageType;
        private String message;
    }
}