package com.santsg.hotel_search.Config;

import com.santsg.hotel_search.Services.SanTsgAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TokenInitializer implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(TokenInitializer.class);

    private final SanTsgAuthService authService;

    public TokenInitializer(SanTsgAuthService authService) {
        this.authService = authService;
    }

 
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            authService.getAuthToken();
            log.info("token alındı ve cachelendi");
        } catch (Exception e) {
            log.error("token alınırken hata oluştu", e);
        }
    }
}
