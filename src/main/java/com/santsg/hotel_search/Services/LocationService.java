package com.santsg.hotel_search.Services;

import com.santsg.hotel_search.DTO.HotelProduct.ArrivalAutocompleteRequest;
import com.santsg.hotel_search.DTO.HotelProduct.ArrivalAutocompleteResponse;
import com.santsg.hotel_search.DTO.HotelProduct.CheckInDatesRequest;
import com.santsg.hotel_search.DTO.HotelProduct.CheckInDatesResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LocationService {

    private final RestTemplate restTemplate;
    private final SanTsgAuthService authService;

    @Value("${santsg.api.base-url}")
    private String sanTsgBaseUrl;

    public LocationService(RestTemplate restTemplate, SanTsgAuthService authService) {
        this.restTemplate = restTemplate;
        this.authService = authService;
    }

    public ArrivalAutocompleteResponse.Body getArrivalAutocomplete(String query) {
        String token = authService.getAuthToken();
        ArrivalAutocompleteRequest apiRequest = new ArrivalAutocompleteRequest(2, query, "en-US");
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ArrivalAutocompleteRequest> requestEntity = new HttpEntity<>(apiRequest, headers);
        String url = sanTsgBaseUrl + "/api/productservice/getarrivalautocomplete";

        ArrivalAutocompleteResponse response = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, ArrivalAutocompleteResponse.class).getBody();

        return (response != null) ? response.getBody() : null;
    }

    public List<String> getCheckInDates(CheckInDatesRequest apiRequest) {
        String token = authService.getAuthToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CheckInDatesRequest> requestEntity = new HttpEntity<>(apiRequest, headers);
        
        String url = sanTsgBaseUrl + "/api/productservice/getcheckindates";

        CheckInDatesResponse response = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, CheckInDatesResponse.class).getBody();

        return (response != null && response.getBody() != null) ? response.getBody().getDates() : null;
    }
}