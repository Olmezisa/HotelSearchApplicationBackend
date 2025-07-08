package com.santsg.hotel_search.DTO.Reponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.ZonedDateTime;

@Data
public class LoginResponse {
    private Body body;

    @Data
    public static class Body {
        private String token;
        private ZonedDateTime expiresOn;
    }
}
