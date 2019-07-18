package com.cleverlance.academy.airlines.mapper;

import com.cleverlance.academy.airlines.model.Destination;
import generated.restclient.model.AirportGen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AirportMapper {

    Destination convertToDestination(AirportGen airport);
}
