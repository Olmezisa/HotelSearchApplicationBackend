package com.santsg.hotel_search.DTO.ProductInfoResponse;

import java.util.List;
import lombok.Data;

@Data
public class FacilityCategory {
    private String name;
    private List<Facility> facilities;
}