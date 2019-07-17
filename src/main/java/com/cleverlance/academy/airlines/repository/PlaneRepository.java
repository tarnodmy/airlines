package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.model.Plane;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PlaneRepository {
    private Map<Long, Plane> planes;

    public PlaneRepository() {
        this.planes = new HashMap<>();
    }

    public void createPlane(final Plane plane) {
        this.planes.put(plane.getId(), plane);
    }

    public void deletePlane(final Long id) {
        this.planes.remove(id);
    }

    public List<Plane> getAllPlanes() {
        return new ArrayList<>(this.planes.values());
    }

    public void updatePlane(final Plane plane) {
        this.planes.remove(plane.getId());
        this.createPlane(plane);
    }

}
