package com.santsg.hotel_search.Controller;

import com.santsg.hotel_search.DTO.ProductInfoRequest;
import com.santsg.hotel_search.DTO.ProductInfoResponse.HotelInfo;
import com.santsg.hotel_search.Services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

   
    @PostMapping("/info")
    public ResponseEntity<HotelInfo> getProductInfo(@RequestBody ProductInfoRequest apiRequest) {
       
        String productId = apiRequest.getProduct();

        if (productId == null || productId.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        log.info("Otel ID: {} için detay bilgileri isteniyor.", productId);
        
        
        HotelInfo hotelInfo = productService.getProductInfo(apiRequest);
        
        if (hotelInfo != null) {
            return ResponseEntity.ok(hotelInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
