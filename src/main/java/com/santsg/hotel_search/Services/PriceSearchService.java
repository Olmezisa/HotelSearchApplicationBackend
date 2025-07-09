package com.santsg.hotel_search.Services;

import com.santsg.hotel_search.DTO.*;
import com.santsg.hotel_search.DTO.response.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class PriceSearchService {

    private final RestTemplate restTemplate;
    private final SanTsgAuthService authService;

    @Value("${santsg.api.base-url}")
    private String baseUrl;

    public PriceSearchService(RestTemplate restTemplate, SanTsgAuthService authService) {
        this.restTemplate = restTemplate;
        this.authService = authService;
    }

    public PriceSearchByLocationResponse handleByLocation(PriceSearchByLocationRequest request) {
        String token = authService.getAuthToken();
        String url = baseUrl + "/api/productservice/pricesearch";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        HttpEntity<PriceSearchByLocationRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<PriceSearchByLocationResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, PriceSearchByLocationResponse.class);

        return response.getBody();
    }

    public PriceSearchByHotelResponse handleByHotel(PriceSearchByHotelRequest request) {
        String token = authService.getAuthToken();
        String url = baseUrl + "/api/productservice/pricesearch";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        HttpEntity<PriceSearchByHotelRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<PriceSearchByHotelResponse> response = restTemplate.exchange(url, HttpMethod.POST, entity, PriceSearchByHotelResponse.class);

        return response.getBody();
    }
}

