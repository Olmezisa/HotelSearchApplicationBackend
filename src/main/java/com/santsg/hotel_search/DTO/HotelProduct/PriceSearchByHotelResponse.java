package com.santsg.hotel_search.DTO.HotelProduct;

import lombok.Data;
import java.util.List;

import com.santsg.hotel_search.Common.Header;

@Data
public class PriceSearchByHotelResponse {

    private Header header;
    private Body body;

  

    @Data
    public static class Body {
        private String searchId;
        private String expiresOn;
        private List<Hotel> hotels;
        private Details details;
    }

    @Data
    public static class Details {
        private boolean enablePaging;
        private boolean getOnlyBestOffers;
    }

    @Data
    public static class Hotel {
        private GeoLocation geolocation;
        private double stars;  // bazen 4.5 gibi decimal var
        private double rating; // ekledim, gördüğüm için
        private List<Theme> themes;
        private List<Facility> facilities; // yeni alan
        private Location location; // json’da var, önceden yoktu
        private Country country;
        private City city;
        private GiataInfo giataInfo;
        private Town town;
        private Village village;
        private List<Offer> offers;
        private String address;
        private int provider;
        private List<BoardGroup> boardGroups;  // json'daki gibi
        private List<Board> boards;
        private HotelCategory hotelCategory;
        private boolean hasThirdPartyOwnOffer;
        private ThirdPartyInformation thirdPartyInformation;
        private boolean hasChannelManagerOffer;
        private String thumbnail;
        private String thumbnailFull;
        private Description description;
        private String id;
        private String name;
    }

    @Data
    public static class GeoLocation {
        private String longitude;
        private String latitude;
    }

    @Data
    public static class Theme {
        private String id;
        private String name;
    }

    @Data
    public static class Facility {
        private boolean isPriced;
        private String id;
        private String name;
    }

    @Data
    public static class Location {
        private String name;
        private String countryId;
        private int provider;
        private boolean isTopRegion;
        private boolean ownLocation;
        private String id;
    }

    @Data
    public static class Country {
        private String internationalCode; // json’da böyle geldi
        private String name;
        private int provider;
        private boolean isTopRegion;
        private boolean ownLocation;
    }

    @Data
    public static class City {
        private String name;
        private String countryId;
        private int provider;
        private boolean isTopRegion;
        private boolean ownLocation;
        private String id;
    }

    @Data
    public static class GiataInfo {
        private String hotelId;
        private String destinationId;
    }

    @Data
    public static class Town {
        private String name;
        private String latitude;
        private String longitude;
        private int provider;
        private String id;
    }

    @Data
    public static class Village {
        private String name;
        private int provider;
        private String id;
    }

    @Data
    public static class Offer {
        private int night;
        private boolean isAvailable;
        private int availability;         // yeni
        private boolean availabilityChecked; // yeni
        private List<Room> rooms;
        private boolean isRefundable;
        private List<CancellationPolicy> cancellationPolicies;  // yeni
        private boolean thirdPartyOwnOffer;                       // yeni
        private List<Object> restrictions;                        // boş array, Object olarak bıraktım
        private List<Object> warnings;                            
        private boolean isChannelManager;                         
        private String expiresOn;
        private String offerId;
        private String checkIn;
        private Price price;
    }

    @Data
    public static class Room {
        private String roomId;
        private String roomName;
        private List<String> roomGroups;
        private String accomId;
        private String accomName;
        private String boardId;
        private String boardName;
        private List<BoardGroup> boardGroups;
        private int allotment;
        private int stopSaleGuaranteed;
        private int stopSaleStandart;
        private Price price;
        private List<Traveller> travellers;
        private ThirdPartyInformation thirdPartyInformation; // oda içi boş obje için
        private boolean visiblePL; // gördüğüm için ekledim
    }

    @Data
    public static class CancellationPolicy {
        private String roomNumber;
        private String dueDate;
        private Price price;
        private int provider;
    }

    @Data
    public static class BoardGroup {
        private String id;
        private String name;
    }

    @Data
    public static class Board {
        private String id;
    }

    @Data
    public static class Price {
        private double amount;
        private String currency;
    }

    @Data
    public static class Traveller {
        private int type;
        private int age;          // json’da var
        private String nationality;
    }

    @Data
    public static class ThirdPartyInformation {
        private List<Object> infos; // boş array olarak gelmiş
    }

    @Data
    public static class HotelCategory {
        private String name;
        private String id;
        private String code;
    }

    @Data
    public static class Description {
        private String text;
    }
}
