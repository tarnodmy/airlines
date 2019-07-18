package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Plane;

import java.util.List;
import java.util.Optional;

public interface IPlaneService {

    List<Plane> getAllPlanes();

    void deletePlane(Long id);

    void updatePlane(Plane plane);

    void createPlane(Plane plane);

    Optional<Plane> getPlaneById(Long planeId);

    Optional<Plane> getPlaneByRegistrationCode(String registrationCode);
}
