package com.divinita.SpringJDBCDivinita.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Applica CORS su tutte le rotte
                    .allowedOrigins("http://localhost:5500")  // Il frontend
                    .allowedMethods("GET", "POST", "PUT", "DELETE")  // Metodi permessi
                    .allowedHeaders("*")  // Permette tutti gli header
                    .allowCredentials(true);  // Consente di inviare credenziali, come i cookie
            }
        };
    }
}
