package com.santsg.hotel_search.Controller;

import com.santsg.hotel_search.DTO.GetOffersRequest;
import com.santsg.hotel_search.DTO.response.GetOffersResponse;
import com.santsg.hotel_search.Services.GetOffersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gateway")
@RequiredArgsConstructor
public class GetOffersController {

    private final GetOffersService getOffersService;

    @PostMapping("/get-offers")
    public ResponseEntity<GetOffersResponse> getOffers(@RequestBody GetOffersRequest requestDto) {
        GetOffersResponse responseDto = getOffersService.getOffers(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
