package com.santsg.hotel_search.DTO.SetReservationInfo;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
import java.util.Map;

/**
 * Rezervasyondaki tek bir yolcunun bilgilerini temsil eder.
 */
@Data
public class TravellerInfo {
    private String travellerId;
    private int type;
    private int title;
    private AcademicTitle academicTitle;
    private int passengerType;
    private String name;
    private String surname;
    
    // API'nin "isleader" (küçük harf) bekleme ihtimaline karşı @JsonProperty kullanıyoruz.
    @JsonProperty("isLeader")
    private boolean isLeader;
    
    private String birthDate; // Format: "yyyy-MM-ddT00:00:00"
    private Nationality nationality;
    private String identityNumber;
    private PassportInfo passportInfo;
    private Address address;
    private Map<String, Object> destinationAddress; // Genellikle boş bir nesne
    private int orderNumber;
    private List<Object> documents; // Genellikle boş bir liste
    private List<Object> insertFields; // Genellikle boş bir liste
    private int status;
    private int gender; // 0: Male, 1: Female

    @Data
    public static class AcademicTitle {
        private int id;
    }

    @Data
    public static class Nationality {
        private String twoLetterCode;
    }

    @Data
    public static class PassportInfo {
        private String serial;
        private String number;
        private String expireDate; // Format: "yyyy-MM-ddT00:00:00"
        private String issueDate;  // Format: "yyyy-MM-ddT00:00:00"
        private String citizenshipCountryCode;
    }

    @Data
    public static class Address {
        private ContactPhone contactPhone;
        private String email;
        private String address;
        private String zipCode;
        private Map<String, String> city;
        private Map<String, String> country;
    }

    @Data
    public static class ContactPhone {
        private String countryCode;
        private String areaCode;
        private String phoneNumber;
    }
}