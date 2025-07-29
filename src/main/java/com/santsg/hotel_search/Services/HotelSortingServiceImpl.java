package com.santsg.hotel_search.Services;

import com.santsg.hotel_search.DTO.HotelProduct.PriceSearchByLocationResponse;
import com.santsg.hotel_search.DTO.HotelProduct.PriceSearchByLocationResponse.Hotel;
import com.santsg.hotel_search.DTO.PriceSearch.PriceSearchByLocationRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;

@Service
public class HotelSortingServiceImpl implements HotelSortingService {

    private final RestTemplate restTemplate;
    private final SanTsgAuthService authService; 

    @Value("${santsg.api.base-url}") 
    private String sanTsgBaseUrl;

    public HotelSortingServiceImpl(RestTemplate restTemplate, SanTsgAuthService authService) {
        this.restTemplate = restTemplate;
        this.authService = authService;
    }

    @Override
    public PriceSearchByLocationResponse searchAndSortHotels(
            PriceSearchByLocationRequest request,
            String sortBy,
            String sortOrder) {

        
        String token = authService.getAuthToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<PriceSearchByLocationRequest> requestEntity = new HttpEntity<>(request, headers);
        String url = sanTsgBaseUrl + "/api/productservice/pricesearch";

        PriceSearchByLocationResponse response = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, PriceSearchByLocationResponse.class).getBody();

        
        if (response == null || response.getBody() == null || response.getBody().getHotels() == null) {
            return response;
        }
        
        
        List<Hotel> hotels = response.getBody().getHotels();
        
        Comparator<Hotel> comparator = switch (sortBy.toLowerCase()) {
            case "price" -> Comparator.comparing(this::getMinPriceForHotel);
            case "stars" -> Comparator.comparingInt(Hotel::getStars);
            case "name" -> Comparator.comparing(Hotel::getName, String.CASE_INSENSITIVE_ORDER);
            default -> null;
        };

        if (comparator != null) {
            if ("desc".equalsIgnoreCase(sortOrder)) {
                comparator = comparator.reversed();
            }
            hotels.sort(comparator);
        }
        
        return response;
    }

    
    private Double getMinPriceForHotel(Hotel hotel) {
        if (hotel.getOffers() == null || hotel.getOffers().isEmpty()) {
            return Double.MAX_VALUE; 
        }
        return hotel.getOffers().stream()
                .map(offer -> offer.getPrice().getAmount())
                .min(Double::compare)
                .orElse(Double.MAX_VALUE);
    }
}