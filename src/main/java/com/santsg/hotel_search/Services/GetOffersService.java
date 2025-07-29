package com.santsg.hotel_search.Services;

import com.santsg.hotel_search.DTO.GetOffers.GetOffersRequest;
import com.santsg.hotel_search.DTO.HotelProduct.GetOffersResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetOffersService {

    private final RestTemplate restTemplate;
    private final SanTsgAuthService authService;

    @Value("${santsg.api.base-url}")
    private String baseUrl;

    
    public GetOffersService(RestTemplate restTemplate, SanTsgAuthService authService) {
        this.restTemplate = restTemplate;
        this.authService = authService;
    }

    
    public GetOffersResponse getOffers(GetOffersRequest request) {
        String token = authService.getAuthToken();
        String url = baseUrl + "/api/productservice/getoffers";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        HttpEntity<GetOffersRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<GetOffersResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                GetOffersResponse.class
        );

        return response.getBody();
    }
}