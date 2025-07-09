package com.santsg.hotel_search.DTO.response;

import java.util.List;

import com.santsg.hotel_search.DTO.Currency;

import lombok.Data;

@Data
public class CurrenciesResponse {
    private Body body;

    @Data
    public static class Body{
        private List<Currency> currencies;
    }
}
