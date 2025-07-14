package com.santsg.hotel_search.Controller;

import com.santsg.hotel_search.DTO.ProductInfoResponse.HotelInfo;
import com.santsg.hotel_search.Services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    
    @PostMapping("/info")
    public ResponseEntity<HotelInfo> getProductInfo(@RequestBody Map<String, String> request) {
        String productId = request.get("product");

        if (productId == null || productId.isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        
        HotelInfo hotelInfo = productService.getProductInfo(productId);
        
        if (hotelInfo != null) {
            return ResponseEntity.ok(hotelInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}