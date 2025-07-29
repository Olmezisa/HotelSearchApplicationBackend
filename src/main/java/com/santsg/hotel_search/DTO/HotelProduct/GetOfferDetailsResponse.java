package com.santsg.hotel_search.DTO.HotelProduct;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class GetOfferDetailsResponse {

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
        private List<OfferDetail> offerDetails;
    }

    @Data
    public static class OfferDetail {
        private String expiresOn;
        private String offerId;
        private String checkIn;
        private String checkOut;
        private boolean isSpecial;
        private boolean isAvailable;
        private boolean isRefundable;
        private Price passengerAmountToPay;
        private Commission agencyCommission;
        private Commission agencySupplementCommission;
        private List<Hotel> hotels;
        private List<ExtraService> extraServices;
        private List<CancellationPolicy> cancellationPolicies;
        private List<PriceBreakdown> priceBreakdowns;
        private int provider;
        private PaymentDetail paymentDetail;
    }

    @Data
    public static class Price {
        private double amount;
        private String currency;
    }

    @Data
    public static class Commission {
        private int percent;
        private double amount;
        private String currency;
    }

    @Data
    public static class Hotel {
        private String id;
        private String name;
        private int stars;
        private double rating;
        private String thumbnail;
        private String thumbnailFull;
        private Description description;
        private List<Season> seasons;
        private Address address;
        private String faxNumber;
        private String phoneNumber;
        private String homePage;
        private List<Room> rooms;
        private Geolocation geolocation;
        private Location location;
        private Country country;
        private City city;
        private GiataInfo giataInfo;
        private List<Offer> offers;
        private int provider;
    }
    
    @Data
    public static class Description {
        private String text;
    }

    @Data
    public static class Season {
        private String name;
        private List<TextCategory> textCategories;
        private List<MediaFile> mediaFiles;
    }

    @Data
    public static class TextCategory {
        private String name;
        private List<Presentation> presentations;
    }

    @Data
    public static class Presentation {
        private int textType;
        private String text;
    }

    @Data
    public static class MediaFile {
        private int fileType;
        private String url;
        private String urlFull;
    }

    @Data
    public static class Address {
        private City city;
        private List<String> addressLines;
        private String street;
        private Geolocation geolocation;
    }

    @Data
    public static class Room {
        private String id;
        private String name;
        private List<Presentation> presentations;
        private List<Facility> facilities;
        private List<MediaFile> mediaFiles;
    }
    
    @Data
    public static class Facility {
        private String name;
    }

    @Data
    public static class Geolocation {
        private String longitude;
        private String latitude;
    }

    @Data
    public static class Location {
        private String id;
        private String name;
        private String latitude;
        private String longitude;
        private int provider;
        private boolean isTopRegion;
    }

    @Data
    public static class Country {
        private String id;
        private String name;
        private int provider;
        private boolean isTopRegion;
    }

    @Data
    public static class City {
        private String id;
        private String name;
        private String latitude;
        private String longitude;
        private int provider;
        private boolean isTopRegion;
    }

    @Data
    public static class GiataInfo {
        private String hotelId;
        private String destinationId;
    }

    @Data
    public static class Offer {
        private boolean isAvailable;
        private int availability;
        private List<OfferRoom> rooms;
        private boolean isRefundable;
    }

    @Data
    public static class OfferRoom {
        private String roomId;
        private String roomName;
        private String boardId;
        private String boardName;
        private List<Traveller> travellers;
        private String roomInfoId;
    }

    @Data
    public static class Traveller {
        private int type;
        private int minAge;
        private int maxAge;
    }

    @Data
    public static class ExtraService {
        private String id;
        private String code;
        private String name;
        private boolean compulsory;
        private boolean free;
        private List<ExtraServiceOffer> offers;
    }

    @Data
    public static class ExtraServiceOffer {
        private int willBePayAt;
        private String checkIn;
        private Price price;
        private ServicePriceBreakDown servicePriceBreakDown;
    }

    @Data
    public static class ServicePriceBreakDown {
        private List<PriceBreakDownItem> items;
    }

    @Data
    public static class PriceBreakDownItem {
        private int type;
        private Price price;
    }
    
    @Data
    public static class CancellationPolicy {
        private String roomNumber;
        private String beginDate;
        private String dueDate;
        private Price price;
        private int provider;
    }

    @Data
    public static class PriceBreakdown {
        private String roomNumber;
        private String date;
        private Price price;
    }

    @Data
    public static class PaymentDetail {
        private List<PaymentPlan> paymentPlan;
        private List<Object> paymentInfo; // The example shows an empty array
    }

    @Data
    public static class PaymentPlan {
        private int paymentNo;
        private String dueDate;
        private Price price;
        private boolean paymentStatus;
    }
}