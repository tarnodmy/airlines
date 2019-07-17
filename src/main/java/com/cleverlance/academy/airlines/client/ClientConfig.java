package com.cleverlance.academy.airlines.client;

import generated.restclient.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.client.ClientBuilder;

@Configuration
public class ClientConfig {

    @Bean
    public ApiClient apiClient() {
        final ApiClient apiClient = new ApiClient();

        apiClient.setBasePath("http://airlabs.co");
        apiClient.setHttpClient(ClientBuilder.newBuilder().build());

        return apiClient;
    }
}
