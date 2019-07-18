package com.cleverlance.academy.airlines.mapper;

import com.cleverlance.academy.airlines.model.Plane;
import generated.rest.model.PlaneGen;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaneMapper {

    PlaneGen convertToPlaneGen(Plane plane);
}
