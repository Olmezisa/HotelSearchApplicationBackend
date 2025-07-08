package com.santsg.hotel_search.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.santsg.hotel_search.DTO.LoginRequest;
import com.santsg.hotel_search.DTO.response.LoginResponse;

import jakarta.annotation.PostConstruct;

@Service
public class SanTsgAuthService {

    private static final Logger log = LoggerFactory.getLogger(SanTsgAuthService.class);

    private final RestTemplate restTemplate;

    
    private SanTsgAuthService self;

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

    
    @Autowired
    public void setSelf(@Lazy SanTsgAuthService self) {
        this.self = self;
    }

    @PostConstruct
    public void init() {
        try {
            log.info("Uygulama başlangıcında ilk token alınıyor...");
            
            self.getAuthToken(); 
            log.info("İlk token başarıyla alındı ve cache'lendi.");
        } catch (Exception e) {
            log.error("", e);
        }
    }
    
    @Cacheable("sanTsgToken") 
    public String getAuthToken() {
        log.info("Cache'de token bulunamadı veya süresi doldu. SAN TSG API'sinden yeni token isteniyor...");
        
        String loginUrl = baseUrl + "/api/authenticationservice/login";
        LoginRequest requestBody = new LoginRequest(agency, user, password);
        
        LoginResponse response = restTemplate.postForObject(loginUrl, requestBody, LoginResponse.class);
        
        if (response != null && response.getBody() != null && response.getBody().getToken() != null) {
            log.info("Yeni token başarıyla alındı.");
            return response.getBody().getToken();
        } else {
            log.error("Token alınamadı! API'den gelen cevapta token bulunmuyor.");
            throw new RuntimeException("Authentication token'ı SAN TSG API'sinden alınamadı.");
        }
    }
}