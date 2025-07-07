package com.santsg.hotel_search.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.santsg.hotel_search.Services.SanTsgAuthService;

@RestController
@RequestMapping("/api/v1/hotels") 
public class HotelController {

    private final SanTsgAuthService authService;
    private final RestTemplate restTemplate;

    @Value("${santsg.api.base-url}")
    private String sanTsgBaseUrl;

    public HotelController(SanTsgAuthService authService) {
        this.authService = authService;
        this.restTemplate = new RestTemplate();
    }

    
    @PostMapping("/search")
    public ResponseEntity<String> searchHotels(@RequestBody Object searchCriteria) {
        
        String token = authService.getAuthToken();
        
        
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(searchCriteria, headers);

        
        String searchUrl = sanTsgBaseUrl + "/api/productservice/search"; 
        
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                searchUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
            );
           
            return response;
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("SAN TSG API'sine istek atılırken bir hata oluştu: " + e.getMessage());
        }
    }
}