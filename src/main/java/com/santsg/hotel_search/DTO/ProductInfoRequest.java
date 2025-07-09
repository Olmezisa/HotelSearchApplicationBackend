package com.santsg.hotel_search.DTO;

import lombok.Data;

@Data
public class ProductInfoRequest {
    private int productType;
    private int ownerProvider;
    private String product;
    private String culture;
}
