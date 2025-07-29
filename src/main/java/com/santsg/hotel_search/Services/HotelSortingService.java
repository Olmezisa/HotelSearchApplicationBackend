package com.santsg.hotel_search.Services;

import com.santsg.hotel_search.DTO.HotelProduct.PriceSearchByLocationResponse;
import com.santsg.hotel_search.DTO.PriceSearch.PriceSearchByLocationRequest;

public interface HotelSortingService {

    PriceSearchByLocationResponse searchAndSortHotels(
        PriceSearchByLocationRequest request,
        String sortBy,
        String sortOrder
    );
}