package com.santsg.hotel_search.DTO.GetOffers;

import lombok.Data;
import java.util.List;

@Data
public class GetOfferDetailsRequest {
    private List<String> offerIds;
    private String currency;
    private boolean getProductInfo = true;
}