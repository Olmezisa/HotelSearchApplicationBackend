package com.santsg.hotel_search.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                     // tüm endpointler için geçerli
                .allowedOrigins("http://localhost:3000") // frontend adresi (vite)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // izin verilen HTTP metodları
                .allowedHeaders("*")                     // tüm headerlara izin ver
                .allowCredentials(true);                 // kimlik bilgilerine izin ver (varsa cookie vb)
    }
}
