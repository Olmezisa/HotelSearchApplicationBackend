package com.santsg.hotel_search.DTO.HotelProduct;

import lombok.Data;

@Data
public class ProductInfoRequest {
    private int productType;
    private int ownerProvider;
    private String product;
    private String culture;
}
