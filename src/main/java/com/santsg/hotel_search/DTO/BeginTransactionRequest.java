package com.santsg.hotel_search.DTO;

import lombok.Data;
import java.util.List;


@Data
public class BeginTransactionRequest {
    private List<String> offerIds;
    private String currency;
    private String culture = "en-US";
}