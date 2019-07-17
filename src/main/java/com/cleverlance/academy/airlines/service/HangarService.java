package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.model.Hangar;
import com.cleverlance.academy.airlines.model.Plane;
import com.cleverlance.academy.airlines.repository.HangarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HangarService implements IHangarService {

    @Autowired
    private HangarRepository hangarRepository;

    @Override
    public List<Hangar> getAllHangars() {
        return hangarRepository.findAll();
    }

    @Override
    public void deleteHangar(final Long id) {
        hangarRepository.deleteById(id);
    }

    @Override
    public void updateHangar(final Hangar hangar) {
        hangarRepository.saveAndFlush(hangar);
    }

    @Override
    public void createHangar(final Hangar hangar) {
        hangarRepository.saveAndFlush(hangar);
    }

    @Override
    public Optional<Hangar> getHangarById(final Long hangarId) {
        return hangarRepository.findById(hangarId);
    }

    @Override
    public void addPlaneToHangar(final Hangar hangar, final Plane plane) {
        final List<Plane> list = hangar.getPlanes();
        if (list == null) {
            hangar.setPlanes(new ArrayList<>());
        }
        hangar.getPlanes().add(plane);
        updateHangar(hangar);
    }

}
