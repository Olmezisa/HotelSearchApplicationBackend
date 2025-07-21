package com.santsg.hotel_search.DTO;
import lombok.Data;
import java.util.List;


@Data
public class RemoveServicesRequest {
    private String transactionId;
    private List<String> services; 
    private String currency;
    private String culture;
}
