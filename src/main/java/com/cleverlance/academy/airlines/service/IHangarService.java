package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Hangar;

import java.util.List;

public interface IHangarService {

    List<Hangar> getAllHangars();

    void deleteHangar(Long id);

    void updateHangar(Hangar hangar);

    void createHangar(Hangar hangar);
}
