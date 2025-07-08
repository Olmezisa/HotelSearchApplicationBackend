package com.santsg.hotel_search.DTO;



import lombok.Data;
import java.util.List;
import java.util.Map;

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
        private Map<String, String> city;
      
    }

    
    @Data
    public static class Geolocation {
        private String longitude;
        private String latitude;
    }
}