package com.cleverlance.academy.airlines;

import com.cleverlance.academy.airlines.mapper.PlaneMapper;
import com.cleverlance.academy.airlines.model.Plane;
import com.cleverlance.academy.airlines.service.IHangarService;
import com.cleverlance.academy.airlines.service.IPlaneService;
import generated.rest.api.PlanesApi;
import generated.rest.model.PlaneGen;
import generated.rest.model.PlaneListGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
public class PlaneController implements PlanesApi {

    @Autowired
    private IPlaneService planeService;

    @Autowired
    private IHangarService hangarService;

    @Autowired
    private PlaneMapper planeMapper;

    @RequestMapping(path = "/planes", method = RequestMethod.GET)
    @Override
    public CompletableFuture<ResponseEntity<PlaneListGen>> getPlanes() {
        final List<Plane> result = planeService.getAllPlanes();
        List<PlaneGen> responseList = result.stream().map(item -> planeMapper.convertToPlaneGen(item)).collect(Collectors.toList());
        PlaneListGen response = new PlaneListGen();
        response.addAll(responseList);
        return CompletableFuture.completedFuture(ResponseEntity.ok(response));
    }

    @RequestMapping(path = "/planes/{registrationCode}", method = RequestMethod.GET)
    public Plane getPlaneByRegistrationCode(@PathVariable("registrationCode") String registrationCode) {
        final Optional<Plane> plane = planeService.getPlaneByRegistrationCode(registrationCode);
        if (plane.isPresent()) {
            return plane.get();
        }
        return null;
    }

    @RequestMapping(path = "/planes", method = RequestMethod.DELETE)
    public void deletePlane(@RequestBody Plane plane) {
        planeService.deletePlane(plane.getId());
    }

    @RequestMapping(path = "/planes", method = RequestMethod.PUT)
    public void updatePlane(@RequestBody Plane plane) {
        planeService.updatePlane(plane);
    }

    @RequestMapping(path = "/planes", method = RequestMethod.POST)
    public void createPlane(@RequestBody Plane plane) {
        planeService.createPlane(plane);
    }

}
