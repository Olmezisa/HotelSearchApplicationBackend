package com.santsg.hotel_search.Controller;

import com.santsg.hotel_search.DTO.GetOffers.GetOfferDetailsRequest;
import com.santsg.hotel_search.DTO.GetOffers.GetOffersRequest;
import com.santsg.hotel_search.DTO.HotelProduct.GetOfferDetailsResponse;
import com.santsg.hotel_search.DTO.HotelProduct.GetOffersResponse;
import com.santsg.hotel_search.Services.GetOfferDetailsService;
import com.santsg.hotel_search.Services.GetOffersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gateway")
@RequiredArgsConstructor
public class GetOffersController {

    private final GetOffersService getOffersService;
    private final GetOfferDetailsService getOfferDetailsService;

    @PostMapping("/get-offers")
    public ResponseEntity<GetOffersResponse> getOffers(@RequestBody GetOffersRequest requestDto) {
        GetOffersResponse responseDto = getOffersService.getOffers(requestDto);
        return ResponseEntity.ok(responseDto);
    }
     @PostMapping("/get-offer-details")
    public ResponseEntity<GetOfferDetailsResponse> getOfferDetails(@RequestBody GetOfferDetailsRequest request) {
        GetOfferDetailsResponse response = getOfferDetailsService.getOfferDetails(request);
        return ResponseEntity.ok(response);
    }
}
