package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Plane;
import com.cleverlance.academy.airlines.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService implements IPlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    @Override
    public List<Plane> getAllPlanes() {
        return planeRepository.getAllPlanes();
    }

    @Override
    public void deletePlane(final Long id) {
        planeRepository.deletePlane(id);
    }

    @Override
    public void updatePlane(final Plane plane) {
        planeRepository.updatePlane(plane);
    }

    @Override
    public void createPlane(final Plane plane) {
        planeRepository.createPlane(plane);
    }
}
