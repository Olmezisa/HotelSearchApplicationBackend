package com.santsg.hotel_search.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.santsg.hotel_search.DTO.ArrivalAutocompleteRequest;
import com.santsg.hotel_search.DTO.CheckInDatesRequest;
import com.santsg.hotel_search.DTO.response.ArrivalAutocompleteResponse;
import com.santsg.hotel_search.DTO.response.CheckInDatesResponse;
import com.santsg.hotel_search.Services.SanTsgAuthService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/locations") 
public class LocationController { 

    private static final Logger log = LoggerFactory.getLogger(LocationController.class);

    private final SanTsgAuthService authService;
    private final RestTemplate restTemplate;

    @Value("${santsg.api.base-url}")
    private String sanTsgBaseUrl;

    public LocationController(SanTsgAuthService authService, RestTemplate restTemplate) {
        this.authService = authService;
        this.restTemplate=restTemplate;
    }

   
    @PostMapping("/autocomplete")
    public ResponseEntity<ArrivalAutocompleteResponse.Body> getArrivalAutocomplete(@RequestBody Map<String, String> request) {
        
        String query = request.get("query");
        if (query == null || query.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        log.info("'{}' için otomatik tamamlama isteği alındı.", query);

        
        String token = authService.getAuthToken();

       
        ArrivalAutocompleteRequest apiRequest = new ArrivalAutocompleteRequest(2, query, "en-US"); 

       
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);

        HttpEntity<ArrivalAutocompleteRequest> requestEntity = new HttpEntity<>(apiRequest, headers);

       
        String url = sanTsgBaseUrl + "/api/productservice/getarrivalautocomplete";
        
        try {
            ResponseEntity<ArrivalAutocompleteResponse> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestEntity,
                    ArrivalAutocompleteResponse.class
            );

            if (response.getBody() != null) {
                return ResponseEntity.ok(response.getBody().getBody());
            } else {
                return ResponseEntity.status(500).build();
            }
        } catch (Exception e) {
            log.error("Autocomplete API isteği sırasında hata: ", e);
            return ResponseEntity.status(500).build();
        }
    }


 @PostMapping("/check-in-dates")
public ResponseEntity<List<String>> getCheckInDates(@RequestBody CheckInDatesRequest apiRequest) {

    log.info("Gelen İstek Gövdesi: {}", apiRequest.toString()); 

    
    String token = authService.getAuthToken();

    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(token);
    headers.setContentType(MediaType.APPLICATION_JSON);
    
    
    HttpEntity<CheckInDatesRequest> requestEntity = new HttpEntity<>(apiRequest, headers);

    String url = sanTsgBaseUrl + "/api/productservice/getcheckindates";
    
    try {
        ResponseEntity<CheckInDatesResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                CheckInDatesResponse.class
        );
        
        if (response.getBody() != null) {
            return ResponseEntity.ok(response.getBody().getBody().getDates());
        } else {
            return ResponseEntity.status(500).build();
        }
    } catch (Exception e) {
        log.error("Giriş tarihleri alınırken hata oluştu: ", e);
        return ResponseEntity.status(500).build();
    }
}
   
}

     