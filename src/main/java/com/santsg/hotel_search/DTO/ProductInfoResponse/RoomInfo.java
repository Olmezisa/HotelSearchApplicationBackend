package com.santsg.hotel_search.DTO.ProductInfoResponse;

import java.util.List;
import lombok.Data;

@Data
public class RoomInfo {
    private String name;
    private String code;
    private List<Presentation> presentations;
    private List<MediaFile> mediaFiles;
    private List<Facility> facilities;
}