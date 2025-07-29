package com.santsg.hotel_search.Controller;


import com.santsg.hotel_search.DTO.HotelProduct.ArrivalAutocompleteResponse;
import com.santsg.hotel_search.DTO.HotelProduct.CheckInDatesRequest;
import com.santsg.hotel_search.Services.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/autocomplete")
    public ResponseEntity<ArrivalAutocompleteResponse.Body> getArrivalAutocomplete(@RequestBody Map<String, String> request) {
        String query = request.get("query");
        if (query == null || query.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        ArrivalAutocompleteResponse.Body responseBody = locationService.getArrivalAutocomplete(query);
        return ResponseEntity.ok(responseBody);
    }

   
    @PostMapping("/check-in-dates")
    public ResponseEntity<List<String>> getCheckInDates(@RequestBody CheckInDatesRequest apiRequest) {
        List<String> dates = locationService.getCheckInDates(apiRequest);
        return ResponseEntity.ok(dates);
    }
}

     