package com.santsg.hotel_search.DTO.GetOffers;

import lombok.Data;

@Data
public class GetOffersRequest {

    private String searchId;
    private String offerId;
    private int productType;
    private String productId;
    private String currency;
    private String culture;
    private boolean getRoomInfo = true;
}
