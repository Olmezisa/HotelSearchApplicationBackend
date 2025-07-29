package com.santsg.hotel_search.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.santsg.hotel_search.DTO.HotelProduct.LoginResponse;
import com.santsg.hotel_search.DTO.PriceSearch.LoginRequest;


@Service
public class SanTsgAuthService {

    private static final Logger log = LoggerFactory.getLogger(SanTsgAuthService.class);

    private final RestTemplate restTemplate;

    @Value("${santsg.api.base-url}")
    private String baseUrl;
    @Value("${santsg.api.agency}")
    private String agency;
    @Value("${santsg.api.user}")
    private String user;
    @Value("${santsg.api.password}")
    private String password;
    
    public SanTsgAuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("sanTsgToken") 
    public String getAuthToken() {
        
        String loginUrl = baseUrl + "/api/authenticationservice/login";
        LoginRequest requestBody = new LoginRequest(agency, user, password);
        
        LoginResponse response = restTemplate.postForObject(loginUrl, requestBody, LoginResponse.class);
        
        if (response != null && response.getBody() != null && response.getBody().getToken() != null) {
            log.info("Yeni token başarıyla alındı.");
            return response.getBody().getToken();
        } else {
            throw new RuntimeException("Authentication token'ı SAN TSG API'sinden alınamadı.");
        }
    }
}