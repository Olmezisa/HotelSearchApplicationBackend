package com.santsg.hotel_search.DTO.CommitTransaction;




import lombok.Data;


@Data
public class CommitTransactionRequest {
    private String transactionId;
    private Integer paymentOption; 

    
}