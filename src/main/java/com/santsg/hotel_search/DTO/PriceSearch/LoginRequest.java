package com.santsg.hotel_search.DTO.PriceSearch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    private String agency;
    private String user;
    private String password;
}
