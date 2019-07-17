package com.cleverlance.academy.airlines.client;

import generated.restclient.ApiClient;
import generated.restclient.ApiException;
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

    public void getAllAirports() {
        try {
            log.info(airportApi.getAllAirports("03b39fd7-c9d5-4c77-a17e-aa7027dab502").toString());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
