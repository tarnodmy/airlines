package com.cleverlance.academy.airlines.client;

import generated.restclient.ApiClient;
import generated.restclient.api.AirportApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Service
@Slf4j
public class AirportClient {

    private AirportApi airportApi;

    @Inject
    private ApiClient apiClient;

    @PostConstruct
    protected void initApi() {
        airportApi = new AirportApi(apiClient);
    }

}
