package com.codingchallenge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Value("${client.url}")
    private String url;

    @Bean
    public String urlFromProperties() {
        return url;
    }
    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
