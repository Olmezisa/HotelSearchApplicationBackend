package com.santsg.hotel_search.DTO.HotelProduct;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.santsg.hotel_search.Common.Header;

import java.util.List;

@Data
public class PriceSearchByLocationResponse {

    private Header header;
    private Body body;


    @Data
    public static class Body {
        private String searchId;
        private String expiresOn;
        private List<Hotel> hotels;
        private List<Tour> tours;
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
        private int stars;
        private int rating;
        private List<Theme> themes;
        private List<Facility> facilities;
        private Location location;
        private Country country;
        private City city;
        private GiataInfo giataInfo;
        private List<Offer> offers;
        private String address;
        private List<BoardGroup> boardGroups;
        private List<Board> boards;
        private List<Badge> badges;
        private HotelCategory hotelCategory;
        private boolean hasThirdPartyOwnOffer;
        private ThirdPartyInformation thirdPartyInformation;
        private boolean hasChannelManagerOffer;
        private int provider;
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
        private String id;
        private String name;
        private boolean isPriced;
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
        private String internationalCode;
        private String name;
        private int provider;
        private boolean ownLocation;
        private boolean isTopRegion;
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
    public static class Board {
        private String id;
    }

    @Data
    public static class BoardGroup {
        private String id;
        private String name;
    }

    @Data
    public static class Badge {
                private String id;
        private String name;
        private String type;
    }

    @Data
    public static class HotelCategory {
        private String name;
        private String id;
        private String code;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ThirdPartyInformation {
        private List<Object> infos; 
    }

    @Data
    public static class Offer {
        private int night;
        private boolean isAvailable;
        private int availability;
        private boolean availabilityChecked;
        private List<Room> rooms;
        private boolean isRefundable;
        private List<CancellationPolicy> cancellationPolicies;
        private boolean thirdPartyOwnOffer;
        private boolean isChannelManager;
        private String expiresOn;
        private String offerId;
        private String checkIn;
        private Price price;
        private List<Object> restrictions;
        private List<Object> warnings;
    }

    @Data
    public static class CancellationPolicy {
        private String roomNumber;
        private String dueDate;
        private Price price;
        private int provider;
    }

    @Data
    public static class Room {
        private String roomId;
        private String roomName;
        private String boardId;
        private String boardName;
        private List<BoardGroup> boardGroups;
        private int stopSaleGuaranteed;
        private int stopSaleStandart;
        private List<Traveller> travellers;
        private ThirdPartyInformation thirdPartyInformation;
        private boolean visiblePL;
    }

    @Data
    public static class Price {
        private double amount;
        private String currency;
    }

    @Data
    public static class Traveller {
        private int type;
        private int age;
        private String nationality;
    }

    @Data
    public static class Description {
        private String text;
    }

    @Data
    public static class Tour {
        
    }
}
