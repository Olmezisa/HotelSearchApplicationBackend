package com.santsg.hotel_search.DTO.Reponse;

import java.util.List;

import lombok.Data;

@Data
public class CheckInDatesResponse {
    private List<String> dates;
}
