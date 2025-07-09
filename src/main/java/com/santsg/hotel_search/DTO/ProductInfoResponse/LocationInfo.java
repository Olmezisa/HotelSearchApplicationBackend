package com.santsg.hotel_search.DTO.ProductInfoResponse;

import lombok.Data;

@Data
public class LocationInfo {
    private String id;
    private String name;
    private String latitude;
    private String longitude;
    private int provider;
    private boolean isTopRegion;
}