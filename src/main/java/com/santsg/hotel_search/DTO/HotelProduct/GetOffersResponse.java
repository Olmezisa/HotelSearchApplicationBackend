package com.santsg.hotel_search.DTO.HotelProduct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GetOffersResponse {

    @JsonProperty("header")
    private Header header;

    @JsonProperty("body")
    private Body body;

    @Data
    public static class Header {
        private String requestId;
        private boolean success;
        private String responseTime;
        private List<Message> messages;
    }

    @Data
    public static class Message {
        private int id;
        private String code;
        private int messageType;
        private String message;
    }

    @Data
    public static class Body {
        private List<Offer> offers;
        private Information information;
        private String productId;

        @JsonProperty("roomInfos")
        private List<RoomInfo> roomInfos;
    }

    @Data
    public static class Offer {
        private int night;
        private boolean isAvailable;
        private int availability;
        private List<Room> rooms;
        private boolean isRefundable;
        private List<CancellationPolicy> cancellationPolicies;
        private List<PriceBreakdownGroup> priceBreakdowns;
        private String expiresOn;
        private String offerId;
        private String checkIn;
        private Price price;
        private boolean ownOffer;
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
        private String roomInfoId;
    }

    @Data
    public static class BoardGroup {
        private String id;
        private String name;
    }

    @Data
    public static class Traveller {
        private int type;
        private int age;
        private String nationality;
        private int minAge;
        private int maxAge;
    }

    @Data
    public static class CancellationPolicy {
        private String dueDate;
        private Price price;
        private int provider;
    }

    @Data
    public static class PriceBreakdownGroup {
        private int productType;
        private List<PriceBreakdown> priceBreakdowns;
    }

    @Data
    public static class PriceBreakdown {
        private String roomNumber;
        private String date;
        private Price price;
    }

    @Data
    public static class Price {
        private double amount;
        private String currency;
    }

    @Data
    public static class Information {
        private int total;
    }

    @Data
    public static class RoomInfo {
        private String name;
        private String id;
        private List<Presentation> presentations;
        private List<Facility> facilities;
        private List<MediaFile> mediaFiles;
    }

    @Data
    public static class Presentation {
        // örneklerde boş olduğu için şimdilik tanımsız, ileride eklenebilir
    }

    @Data
    public static class Facility {
        private String name;
    }

    @Data
    public static class MediaFile {
        private int fileType;
        private String urlFull;
    }
}

