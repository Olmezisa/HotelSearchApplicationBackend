package com.santsg.hotel_search.DTO;

import com.santsg.hotel_search.DTO.response.GetOfferDetailsResponse.Header;

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