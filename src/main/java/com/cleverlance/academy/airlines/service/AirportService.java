package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.client.IAirportClient;
import com.cleverlance.academy.airlines.model.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService implements IAirportService {

    @Autowired
    private IAirportClient airportClient;

    @Override
    public List<Destination> getAllAirports() {
        return airportClient.getAllAirports();
    }
}
