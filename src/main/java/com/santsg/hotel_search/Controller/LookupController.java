package com.santsg.hotel_search.Controller;

import com.santsg.hotel_search.DTO.HotelProduct.Currency;
import com.santsg.hotel_search.DTO.HotelProduct.Nationality;
import com.santsg.hotel_search.Services.LookupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lookups")
public class LookupController {

    private final LookupService lookupService;

    public LookupController(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    
    @GetMapping("/nationalities")
    public ResponseEntity<List<Nationality>> getNationalities() {
        List<Nationality> nationalities = lookupService.getNationalities();
        return ResponseEntity.ok(nationalities);
    }

    
    @GetMapping("/currencies")
    public ResponseEntity<List<Currency>> getCurrencies() {
        List<Currency> currencies = lookupService.getCurrencies();
        return ResponseEntity.ok(currencies);
    }
}




    

