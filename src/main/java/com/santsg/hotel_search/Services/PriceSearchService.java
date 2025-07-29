package com.santsg.hotel_search.Services;

import com.santsg.hotel_search.DTO.HotelProduct.*;
import com.santsg.hotel_search.DTO.PriceSearch.PriceSearchByHotelRequest;
import com.santsg.hotel_search.DTO.PriceSearch.PriceSearchByLocationRequest;

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


    private <Q, S> S performSearch(Q request, Class<S> responseType) {
        String token = authService.getAuthToken();
        String url = baseUrl + "/api/productservice/pricesearch";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(token);

        HttpEntity<Q> entity = new HttpEntity<>(request, headers);
        ResponseEntity<S> response = restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
        
        return response.getBody();
    }

    public PriceSearchByLocationResponse handleByLocation(PriceSearchByLocationRequest request) {
       
        return performSearch(request, PriceSearchByLocationResponse.class);
    }

    public PriceSearchByHotelResponse handleByHotel(PriceSearchByHotelRequest request) {
        
        return performSearch(request, PriceSearchByHotelResponse.class);
    }
}