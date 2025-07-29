package com.santsg.hotel_search.Services;

import com.santsg.hotel_search.DTO.GetOffers.GetOfferDetailsRequest;
import com.santsg.hotel_search.DTO.HotelProduct.GetOfferDetailsResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetOfferDetailsService {

    private final RestTemplate restTemplate;
    private final SanTsgAuthService authService;

    @Value("${santsg.api.base-url}")
    private String baseUrl;

    public GetOfferDetailsService(RestTemplate restTemplate, SanTsgAuthService authService) {
        this.restTemplate = restTemplate;
        this.authService = authService;
    }

    public GetOfferDetailsResponse getOfferDetails(GetOfferDetailsRequest request) {
        String token = authService.getAuthToken();
        String url = baseUrl + "/api/productservice/getofferdetails";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        HttpEntity<GetOfferDetailsRequest> entity = new HttpEntity<>(request, headers);
        
        ResponseEntity<GetOfferDetailsResponse> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                GetOfferDetailsResponse.class
        );

        return response.getBody();
    }
}