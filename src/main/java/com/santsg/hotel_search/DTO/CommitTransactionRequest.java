package com.santsg.hotel_search.DTO;




import lombok.Data;


@Data

public class CommitTransactionRequest {
    private String transactionId;
    private Integer paymentOption; 

    
}