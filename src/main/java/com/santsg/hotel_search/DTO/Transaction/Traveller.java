package com.santsg.hotel_search.DTO.Transaction;


import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
    public  class Traveller {
        private String travellerId;
        private int type;
        private int title;
        private List<Map<String, String>> availableTitles;
        private Map<String, String> academicTitle;
        private List<AcademicTitleInfo> availableAcademicTitles;
        private boolean isLeader;
        private String birthDate;
        private NationalityInfo nationality;
        private PassportInfo passportInfo;
        private Address address;
        private List<Service> services;
        private int orderNumber;
        private String birthDateFrom;
        private String birthDateTo;
        private List<String> requiredFields;
        private int passengerType;
        private Map<String, String> additionalFields;
    }