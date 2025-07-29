package com.santsg.hotel_search.Controller;

import com.santsg.hotel_search.DTO.HotelProduct.PriceSearchByLocationResponse;
import com.santsg.hotel_search.DTO.PriceSearch.PriceSearchByLocationRequest;
import com.santsg.hotel_search.Services.HotelSortingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sorting")
public class HotelSortingController {

    private final HotelSortingService hotelSearchService;

    @Autowired
    public HotelSortingController(HotelSortingService hotelSearchService) {
        this.hotelSearchService = hotelSearchService;
    }

    @PostMapping("/search")
    public ResponseEntity<PriceSearchByLocationResponse> searchHotels(
            @RequestBody PriceSearchByLocationRequest request,
            @RequestParam(name = "sortBy", defaultValue = "price", required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = "asc", required = false) String sortOrder) {
        
        PriceSearchByLocationResponse sortedResponse = hotelSearchService.searchAndSortHotels(request, sortBy, sortOrder);
        
        if (sortedResponse == null || !sortedResponse.getHeader().isSuccess()) {
             return ResponseEntity.status(500).body(sortedResponse);
        }
        
        return ResponseEntity.ok(sortedResponse);
    }
}