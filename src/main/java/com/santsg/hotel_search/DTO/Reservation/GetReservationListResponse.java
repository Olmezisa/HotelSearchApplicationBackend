package com.santsg.hotel_search.DTO.Reservation;


import lombok.Data;
import java.util.List;

import com.santsg.hotel_search.Common.Header;
import com.santsg.hotel_search.DTO.Reservation.GetReservationDetailResponse.PaymentPlan;
import com.santsg.hotel_search.DTO.Reservation.GetReservationDetailResponse.Price;


@Data
public class GetReservationListResponse {
    private Header header;
    private Body body;

    @Data
    public static class Body {
        private List<ReservationSummary> reservations;
        private int totalCount;
        private int maxIndexNumber;
        private int minIndexNumber;
    }

    @Data
    public static class ReservationSummary {
        private String reservationNumber;
        private String encryptedReservationNumber;
        private String beginDate;
        private String endDate;
        private int night;
        private String leaderName;
        private String agency;
        private String agencyUser;
        private int adult;
        private int child;
        private String registerDate;
        private int reservationStatus;
        private int confirmationStatus;
        private int paymentStatus;
        private Price salePrice;
        private SimpleLocation departureCity;
        private SimpleLocation arrivalCity;
        private String reservationNote;
        private String serviceTypes;
        private List<PaymentPlan> paymentPlan;
        private List<DocumentSummary> documents;
        private String pnrNo;
        private String ticketNos;
        private List<ServiceSummary> services;
        private String createDate;
        private String confirmationDate;
    }

    @Data
    public static class SimpleLocation {
        private String id;
        private String name;
        private int provider;
        private boolean isTopRegion;
    }

    @Data
    public static class DocumentSummary {
        private int documentType;
        private String url;
        private boolean isDefault;
        private boolean proforma;
    }

    @Data
    public static class ServiceSummary {
        private String code;
        private String name;
        private int productType;
        private String serviceType;
        private int statConf;
    }
}