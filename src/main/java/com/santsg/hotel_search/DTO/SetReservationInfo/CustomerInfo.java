package com.santsg.hotel_search.DTO.SetReservationInfo;

import lombok.Data;


@Data
public class CustomerInfo {
    private boolean isCompany;
    private String name;
    private String surname;
    private String birthDate;
    private String identityNumber;
    private TravellerInfo.Address address;
    
}