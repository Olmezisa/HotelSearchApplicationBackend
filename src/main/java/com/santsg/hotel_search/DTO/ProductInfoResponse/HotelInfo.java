package com.santsg.hotel_search.DTO.ProductInfoResponse;

import java.util.List;
import lombok.Data;

@Data
public class HotelInfo {
    private String id;
    private String name;
    private String code;
    private int provider;
    private int stars;
    private String thumbnail;
    private String thumbnailFull;
    private String faxNumber;
    private String phoneNumber;
    private String homePage;
    private List<Season> seasons;
    private List<RoomInfo> rooms;
    private List<Board> boards;
    private List<PaymentPlanInfo> paymentPlanInfo;
    private LocationInfo location;
    private LocationInfo country;
    private LocationInfo city;
    private LocationInfo town;
    private HotelCategory hotelCategory;
}