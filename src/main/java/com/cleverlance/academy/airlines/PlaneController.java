package com.cleverlance.academy.airlines;

import com.cleverlance.academy.airlines.model.Plane;
import com.cleverlance.academy.airlines.service.IPlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaneController {

    @Autowired
    private IPlaneService planeService;

    @RequestMapping(path = "/planes", method = RequestMethod.GET)
    public List<Plane> getPlanes() {
        return planeService.getAllPlanes();
    }

    @RequestMapping(path = "/planes", method = RequestMethod.POST)
    public void createPlane(@RequestBody Plane plane) {
        planeService.createPlane(plane);
    }

    @RequestMapping(path = "/planes", method = RequestMethod.DELETE)
    public void deletePlane(@RequestBody Plane plane) {
        planeService.deletePlane(plane.getId());
    }

    @RequestMapping(path = "/planes", method = RequestMethod.PUT)
    public void updatePlane(@RequestBody Plane plane) {
        planeService.updatePlane(plane);
    }
}
