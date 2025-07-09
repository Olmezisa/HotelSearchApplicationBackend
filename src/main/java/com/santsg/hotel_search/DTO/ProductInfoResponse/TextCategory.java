package com.santsg.hotel_search.DTO.ProductInfoResponse;

import java.util.List;
import lombok.Data;

@Data
public class TextCategory {
    private String code;
    private String name;
    private List<Presentation> presentations;
}