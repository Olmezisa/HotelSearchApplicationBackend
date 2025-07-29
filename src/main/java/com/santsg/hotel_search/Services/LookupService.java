package com.santsg.hotel_search.Services;

import com.santsg.hotel_search.DTO.HotelProduct.CurrenciesResponse;
import com.santsg.hotel_search.DTO.HotelProduct.Currency;
import com.santsg.hotel_search.DTO.HotelProduct.NationalitiesResponse;
import com.santsg.hotel_search.DTO.HotelProduct.Nationality;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LookupService {

    private final RestTemplate restTemplate;
    private final SanTsgAuthService authService;

    @Value("${santsg.api.base-url}")
    private String sanTsgBaseUrl;

    public LookupService(RestTemplate restTemplate, SanTsgAuthService authService) {
        this.restTemplate = restTemplate;
        this.authService = authService;
    }

    public List<Nationality> getNationalities() {
        String token = authService.getAuthToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>("{}", headers);
        String url = sanTsgBaseUrl + "/api/lookupservice/getnationalities";

        NationalitiesResponse response = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, NationalitiesResponse.class).getBody();

        return (response != null && response.getBody() != null) ? response.getBody().getNationalities() : null;
    }

    public List<Currency> getCurrencies() {
        String token = authService.getAuthToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>("{}", headers);
        String url = sanTsgBaseUrl + "/api/lookupservice/getcurrencies";

        CurrenciesResponse response = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, CurrenciesResponse.class).getBody();

        return (response != null && response.getBody() != null) ? response.getBody().getCurrencies() : null;
    }
}