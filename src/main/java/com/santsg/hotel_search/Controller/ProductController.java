package com.santsg.hotel_search.Controller;


import com.santsg.hotel_search.DTO.ProductInfoResponse.HotelInfo;
import com.santsg.hotel_search.Services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/info")
    public ResponseEntity<HotelInfo> getProductInfo(@RequestBody Map<String, String> request) {
        String productId = request.get("product");
        String providerStr = request.get("provider");

        if (productId == null || productId.isBlank() || providerStr == null) {
            return ResponseEntity.badRequest().build();
        }

        try {
            int provider = Integer.parseInt(providerStr);
            log.info("Otel ID: {} ve Provider: {} için detay bilgileri isteniyor.", productId, provider);
            
            HotelInfo hotelInfo = productService.getProductInfo(productId, provider);
            
            if (hotelInfo != null) {
                return ResponseEntity.ok(hotelInfo);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            log.error("Geçersiz provider ID formatı: {}", providerStr);
            return ResponseEntity.badRequest().body(null);
        }
    }
}
