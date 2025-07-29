package com.santsg.hotel_search.Controller;

import com.santsg.hotel_search.DTO.HotelProduct.*;
import com.santsg.hotel_search.DTO.PriceSearch.PriceSearchByHotelRequest;
import com.santsg.hotel_search.DTO.PriceSearch.PriceSearchByLocationRequest;
import com.santsg.hotel_search.Services.PriceSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/price-search")
public class PriceSearchController {

    private final PriceSearchService priceSearchService;

    public PriceSearchController(PriceSearchService priceSearchService) {
        this.priceSearchService = priceSearchService;
    }

    @PostMapping("/by-location")
    public ResponseEntity<PriceSearchByLocationResponse> searchByLocation(@RequestBody PriceSearchByLocationRequest request) {
        PriceSearchByLocationResponse response = priceSearchService.handleByLocation(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/by-hotel")
    public ResponseEntity<PriceSearchByHotelResponse> searchByHotel(@RequestBody PriceSearchByHotelRequest request) {
        PriceSearchByHotelResponse response = priceSearchService.handleByHotel(request);
        return ResponseEntity.ok(response);
    }
}
