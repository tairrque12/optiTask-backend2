package com.optitask.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/*
WHEN REACT SENDS A REQUEST TO SPRING BOOT, SPRING CHECKS THIS CONFIG FILE FIRST.
IF THE REQUEST COMES FROM PORTS LISTED, USE THE 3 HTTP METHODS LISTED, EVERYTHING ELSE GETS BLOCKED.
 */


//TELLS SPRING THIS CREATES APP WIDE SETTINGS, SPRING READS THEN STARTS APP.
@Configuration
public class CorsConfig {

    //TELLS SPRING, CREATE THIS OBJECT AND MANAGE IT. MAKE IT AVAILABLE TO THE WHOLE APP.
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/api/**")
                        //TELLS SPRING TO ONLY ALLOW REQUEST FROM THESE 2.
                        .allowedOrigins("http://localhost:5173", "http://localhost:3000")
                        //TELLS SPRING ONLY ALLOW THESE 4 HTTP METHODS
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*");

            }
        };
    }
}