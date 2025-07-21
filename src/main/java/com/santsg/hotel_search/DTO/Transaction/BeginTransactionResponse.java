package com.santsg.hotel_search.DTO.Transaction;


import lombok.Data;


@Data
public class BeginTransactionResponse {
    private Body body;
    private Header header;

    @Data
    public static class Body{
        private String transactionId;
        private String expiresOn;
        private ReservationData reservationData;
        private int status;
        private int transactionType;

    }

}