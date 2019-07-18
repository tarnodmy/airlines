package com.cleverlance.academy.airlines.client;

import generated.restclient.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.client.ClientBuilder;

@Configuration
public class ClientConfig {

    @Value("${airlines.airports.url}")
    private String url;

    @Bean
    public ApiClient apiClient() {
        final ApiClient apiClient = new ApiClient();

        apiClient.setBasePath(url);
        apiClient.setHttpClient(ClientBuilder.newBuilder().build());

        return apiClient;
    }
}
