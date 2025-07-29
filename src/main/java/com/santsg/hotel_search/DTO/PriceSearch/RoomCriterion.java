package com.santsg.hotel_search.DTO.PriceSearch;

import lombok.Data;
import java.util.List;

@Data
public class RoomCriterion {
    private int adult;
    private List<Integer> childAges;
}