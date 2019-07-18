package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.model.Plane;

import java.util.List;
import java.util.Optional;

public interface IHangarService {

    List<Hangar> getAllHangars();

    void deleteHangar(Long id);

    void updateHangar(Hangar hangar);

    void createHangar(Hangar hangar);

    Optional<Hangar> getHangarById(Long hangarId);

    void addPlaneToHangar(Hangar hangar, Plane plane);
}
