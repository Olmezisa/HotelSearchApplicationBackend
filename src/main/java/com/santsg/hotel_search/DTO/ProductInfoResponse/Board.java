package com.santsg.hotel_search.DTO.ProductInfoResponse;
import java.util.List;
import lombok.Data;

@Data
public class Board {
    private String code;
    private String name;
    private List<Presentation> presentations;
    private List<MediaFile> mediaFiles;
}