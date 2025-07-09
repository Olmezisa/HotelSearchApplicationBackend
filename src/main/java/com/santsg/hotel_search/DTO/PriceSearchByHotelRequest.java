package com.santsg.hotel_search.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PriceSearchByHotelRequest {

    private boolean checkAllotment;
    private boolean checkStopSale;
    private boolean getOnlyDiscountedPrice;
    private boolean getOnlyBestOffers;
    private int productType;

    @JsonProperty("Products")
    private List<String> products;

    private List<ProductPriceCategory> productPriceCategories;

    private List<RoomCriterion> roomCriteria;

    private String nationality;
    private String checkIn;
    private int night;
    private String currency;
    private String culture = "en-US";

    @Data
    public static class ProductPriceCategory {
        private String product;
        private String category;
    }

    @Data
    public static class RoomCriterion {
        private int adult;
        private List<Integer> childAges;
    }
}
