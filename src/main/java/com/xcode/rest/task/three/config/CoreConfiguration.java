package com.xcode.rest.task.three.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CoreConfiguration {

    @Value("${nbp.api.endpoint.prod}")
    private String nbpApiEndpoint;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getNbpApiEndpoint() {
        return nbpApiEndpoint;
    }
}
