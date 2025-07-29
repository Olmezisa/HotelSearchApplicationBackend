package com.santsg.hotel_search.DTO.Reservation;


import lombok.Data;
import java.util.List;
import java.util.Map;

import com.santsg.hotel_search.Common.Header;


@Data
public class GetReservationDetailResponse {
    private Header header;
    private Body body;

    @Data
    public static class Body {
        private String reservationNumber;
        private String encryptedReservationNumber;
        private String transactionId;
        private ReservationData reservationData;
        private int status;
    }

    @Data
    public static class ReservationData {
        private List<Traveller> travellers;
        private ReservationInfo reservationInfo;
        private List<Service> services;
        private PaymentDetail paymentDetail;
        private List<Object> invoices;
    }

    @Data
    public static class Traveller {
        private String travellerId;
        private int type;
        private int title;
        private List<Map<String, String>> availableTitles;
        private Map<String, String> academicTitle;
        private List<AcademicTitleInfo> availableAcademicTitles;
        private String name;
        private String surname;
        private boolean isLeader;
        private String birthDate;
        private int age;
        private NationalityInfo nationality;
        private PassportInfo passportInfo;
        private Address address;
        private List<ServiceInfo> services;
        private int gender;
        private int orderNumber;
        private List<String> requiredFields;
        private int passengerType;
        private Map<String, String> additionalFields;
    }
    
    @Data
    public static class AcademicTitleInfo {
        private String id;
        private String name;
    }

    @Data
    public static class NationalityInfo {
        private String name;
        private String twoLetterCode;
        private String threeLetterCode;
        private String numericCode;
        private String isdCode;
    }

    @Data
    public static class PassportInfo {
        private String serial;
        private String number;
        private String expireDate;
        private String issueDate;
        private String citizenshipCountryCode;
    }

    @Data
    public static class Address {
        private Map<String, String> contactPhone;
        private String email;
        private String address;
        private String zipCode;
        private Map<String, String> city;
        private Map<String, String> country;
    }

    @Data
    public static class ServiceInfo {
        private String id;
        private int type;
        private String ticketNo;
        private Price price;
        private int passengerType;
    }

    @Data
    public static class Price {
        private double amount;
        private String currency;
    }

    @Data
    public static class ReservationInfo {
        private String bookingNumber;
        private String encryptedBookingNumber;
        private String beginDate;
        private String endDate;
        private String note;
        private String agencyReservationNumber;
        private Price salePrice;
        private Price agencyAmountToPay;
        private Price passengerAmountToPay;
        private Price totalPrice;
        private AgencyCommission agencyCommission;
        private int reservationStatus;
        private int confirmationStatus;
        private int paymentStatus;
        private List<Document> documents;
        private String createDate;
        private String changeDate;
    }

    @Data
    public static class AgencyCommission {
        private double percent;
        private double amount;
        private String currency;
    }

    @Data
    public static class Document {
        private int documentType;
        private String url;
        private String name;
        private boolean isDefault;
        private boolean proforma;
    }

    @Data
    public static class Service {
        private String id;
        private String code;
        private String name;
        private String beginDate;
        private String endDate;
        private int adult;
        private int child;
        private Price price;
        private int provider;
        private List<String> travellers;
        private ServiceDetails serviceDetails;
        private List<CancellationPolicy> cancellationPolicies;
        private String supplierBookingNumber;
        private boolean isMainService;
    }

    @Data
    public static class ServiceDetails {
        private String serviceId;
        private HotelDetail hotelDetail;
        private int night;
        private String room;
        private String board;
        private String accom;
    }

    @Data
    public static class HotelDetail {
        private String id;
        private String name;
        private LocationInfo location;
        private LocationInfo country;
        private LocationInfo city;
    }

    @Data
    public static class LocationInfo {
        private String id;
        private String name;
        private String code;
        private int type;
    }
    
    @Data
    public static class CancellationPolicy {
        private String dueDate;
        private Price price;
        private int provider;
    }

    @Data
    public static class PaymentDetail {
        private List<PaymentPlan> paymentPlan;
    }

    @Data
    public static class PaymentPlan {
        private int paymentNo;
        private String dueDate;
        private Price price;
        private boolean paymentStatus;
    }
}