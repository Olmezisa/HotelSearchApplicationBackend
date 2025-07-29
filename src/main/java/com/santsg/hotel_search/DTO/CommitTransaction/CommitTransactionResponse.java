package com.santsg.hotel_search.DTO.CommitTransaction;

import com.santsg.hotel_search.DTO.HotelProduct.GetOfferDetailsResponse.Header;

import lombok.Data;

@Data
public class CommitTransactionResponse {
    private Header header;
    private Body body;

    @Data
    public static class Body {
        private String reservationNumber;
        private String encryptedReservationNumber;
        private String transactionId;
    }
}