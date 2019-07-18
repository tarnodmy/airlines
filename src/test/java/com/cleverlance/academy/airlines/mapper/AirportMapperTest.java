package com.cleverlance.academy.airlines.mapper;

import com.cleverlance.academy.airlines.model.Destination;
import generated.restclient.model.AirportGen;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportMapperTest {

    private AirportMapper mapper = new AirportMapperImpl();

    @Test
    public void convertToDestination() {
        final AirportGen data = new AirportGen().code("ABC").name("Abeceda");
        final Destination converted = mapper.convertToDestination(data);

        assertEquals("ABC", converted.getCode());
        assertEquals("Abeceda", converted.getName());
    }
}