package com.santsg.hotel_search.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santsg.hotel_search.Services.SanTsgAuthService;

@RestController
@RequestMapping("/api/v1/test")
public class TestAuthController {

    private final SanTsgAuthService authService;

    public TestAuthController(SanTsgAuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/token")
    public ResponseEntity<String> getToken() {
        try {
            String token = authService.getAuthToken();
            return ResponseEntity.ok("token have taken succesfuly: " + token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("token can not be taken: " + e.getMessage());
        }
    }
}
