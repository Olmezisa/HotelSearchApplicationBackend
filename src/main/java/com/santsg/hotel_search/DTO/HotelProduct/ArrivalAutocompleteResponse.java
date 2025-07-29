package com.santsg.hotel_search.DTO.HotelProduct;



import lombok.Data;
import java.util.List;
import java.util.Map;

import com.santsg.hotel_search.DTO.PriceSearch.GiataInfo;

@Data
public class ArrivalAutocompleteResponse {
    private Body body;

    @Data
    public static class Body {
        private List<Item> items;
    }

    
    @Data
    public static class Item {
        private int type;
        private Geolocation geolocation;
        private Map<String, String> country;
        private Map<String, String> state;
        private Map<String, String> city;
        private GiataInfo giataInfo; 
        private Hotel hotel;
        private int provider;
    }


    @Data
    public static class Hotel{
        private String internationalName;
        private String id;
        private String name;
    }
    
    @Data
    public static class Geolocation {
        private String longitude;
        private String latitude;
    }
}