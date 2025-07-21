package com.santsg.hotel_search.DTO.Transaction;

import lombok.Data;
import java.util.Map;
@Data
public class Address {
    private String email;
    private String address;
    private String zipCode;
    private Map<String, String> city;
    private Map<String, String> country;
}