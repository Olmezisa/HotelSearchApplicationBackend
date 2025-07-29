package com.santsg.hotel_search.Services;

import com.santsg.hotel_search.DTO.HotelProduct.ProductInfoRequest;
import com.santsg.hotel_search.DTO.ProductInfoResponse.HotelInfo;
import com.santsg.hotel_search.DTO.ProductInfoResponse.ProductInfoApiResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    private final RestTemplate restTemplate;
    private final SanTsgAuthService authService;

    @Value("${santsg.api.base-url}")
    private String sanTsgBaseUrl;

    public ProductService(RestTemplate restTemplate, SanTsgAuthService authService) {
        this.restTemplate = restTemplate;
        this.authService = authService;
    }

   
    public HotelInfo getProductInfo(String productId, int provider) {
        String token = authService.getAuthToken();

        ProductInfoRequest apiRequest = new ProductInfoRequest();
        apiRequest.setProduct(productId);
        apiRequest.setProductType(2);
        
        apiRequest.setOwnerProvider(provider);
        apiRequest.setCulture("en-US");

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("ngrok-skip-browser-warning", "true"); 
        HttpEntity<ProductInfoRequest> requestEntity = new HttpEntity<>(apiRequest, headers);
        
        String url = sanTsgBaseUrl + "/api/productservice/getproductinfo";

        ProductInfoApiResponse response = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, ProductInfoApiResponse.class).getBody();

        if (response != null && response.getBody() != null) {
            return response.getBody().getHotel();
        }
        return null;
    }
}