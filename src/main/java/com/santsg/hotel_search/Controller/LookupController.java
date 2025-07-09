package com.santsg.hotel_search.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.santsg.hotel_search.DTO.Nationality;
import com.santsg.hotel_search.DTO.response.CurrenciesResponse;
import com.santsg.hotel_search.DTO.response.NationalitiesResponse;
import com.santsg.hotel_search.Services.SanTsgAuthService;

@RestController
@RequestMapping("/api/v1/lookups")
public class LookupController {
    private static final Logger log = LoggerFactory.getLogger(LookupController.class);
    private final SanTsgAuthService authService;
    private final RestTemplate restTemplate;
    

    @Value("${santsg.api.base-url}")
    private String sanTsgBaseUrl;

    public LookupController(SanTsgAuthService authService,RestTemplate restTemplate){
        this.authService=authService;
        this.restTemplate=restTemplate;
    }

    @GetMapping("/getNationalities")
    public ResponseEntity<List<Nationality>> getNationality(){
        
        String token =authService.getAuthToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>("{}", headers);

        String url = sanTsgBaseUrl + "/api/lookupservice/getnationalities";

        try {
           
            ResponseEntity<NationalitiesResponse> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST, 
                    requestEntity,
                    NationalitiesResponse.class
            );

           
            if (response.getBody() != null && response.getBody().getBody() != null) {
                return ResponseEntity.ok(response.getBody().getBody().getNationalities());
            } else {
                return ResponseEntity.status(500).build();
            }

        } catch (Exception e) {
            log.error("", e);
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/getCurrencies")
    public ResponseEntity<List<com.santsg.hotel_search.DTO.Currency>> getCurrencies(){
        String token = authService.getAuthToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>("{}", headers);

        String url = sanTsgBaseUrl + "/api/lookupservice/getcurrencies";

         try {
       
        ResponseEntity<CurrenciesResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                CurrenciesResponse.class
        );

        
        if (response.getBody() != null && response.getBody().getBody() != null) {
            return ResponseEntity.ok(response.getBody().getBody().getCurrencies());
        } else {
            return ResponseEntity.status(500).build();
        }

    } catch (Exception e) {
        log.error("Para birimi listesi alınırken hata oluştu: ", e);
        return ResponseEntity.status(500).build();
    }
}

}
    




    

