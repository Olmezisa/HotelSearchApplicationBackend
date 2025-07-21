package com.santsg.hotel_search.DTO.Transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class AcademicTitleInfo {
    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
}