package com.santsg.hotel_search.DTO;

import lombok.Data;
import java.util.List;

@Data
public class RoomCriterion {
    private int adult;
    private List<Integer> childAges;
}