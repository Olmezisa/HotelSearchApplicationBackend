package com.santsg.hotel_search.DTO.PriceSearch;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PriceSearchByLocationRequest {

    private boolean checkAllotment;
    private boolean checkStopSale;
    private boolean getOnlyDiscountedPrice;
    private boolean getOnlyBestOffers;
    private int productType;

    private List<ArrivalLocation> arrivalLocations;

    private List<RoomCriterion> roomCriteria;

    private String nationality;
    private String checkIn;
    private int night;
    private String currency;
    private String culture = "en-US";

    @Data
    public static class ArrivalLocation {
        @JsonProperty("id")
        private String id;

        @JsonProperty("type")
        private int type=2;
    }

    @Data
    public static class RoomCriterion {
        private int adult;
        private List<Integer> childAges;
    }
}
