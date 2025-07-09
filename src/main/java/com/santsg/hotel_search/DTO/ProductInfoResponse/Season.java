package com.santsg.hotel_search.DTO.ProductInfoResponse;

import java.util.List;
import lombok.Data;

@Data
public class Season {
    private int id;
    private String name;
    private List<TextCategory> textCategories;
    private List<FacilityCategory> facilityCategories;
    private List<MediaFile> mediaFiles;
}