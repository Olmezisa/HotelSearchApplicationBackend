package com.santsg.hotel_search.Services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.santsg.hotel_search.DTO.LoginRequest;
import com.santsg.hotel_search.DTO.Reponse.LoginResponse;

import jakarta.annotation.PostConstruct;

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
    
    
    public SanTsgAuthService() {
        this.restTemplate = new RestTemplate();
    }
     @PostConstruct
    public void init() {
        try {
            log.info("Uygulama başlangıcında token alınıyor");
            getAuthToken(); 
            log.info("Token başarıyla alındı ve cache'lendi.");
        } catch (Exception e) {
            log.error("Uygulama başlangıcında token alınamadı: ", e);
            
        }
    }
    
    @Cacheable("sanTsgToken") 
    public String getAuthToken() {
        log.info("token can not be taken");
        
        String loginUrl = baseUrl + "/api/authenticationservice/login";
        LoginRequest requestBody = new LoginRequest(agency, user, password);
        
        LoginResponse response = restTemplate.postForObject(loginUrl, requestBody, LoginResponse.class);
        
        if (response != null && response.getBody() != null && response.getBody().getToken() != null) {
            log.info("token taken succesfully");
            return response.getBody().getToken();
        } else {
            log.error("Token can not be taken");
            throw new RuntimeException("can not take authentication token from SAN TSG API");
        }
    }
}