package com.cleverlance.academy.airlines.service;

import com.cleverlance.academy.airlines.client.IAirportClient;
import com.cleverlance.academy.airlines.model.Destination;
import com.cleverlance.academy.airlines.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AirportService implements IAirportService {

    @Autowired
    private IAirportClient airportClient;

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public List<Destination> getAllAirports() {
        return airportClient.getAllAirports();
    }

    @Scheduled(fixedRate = 3600000)
    private void updateAirports() {
        final List<Destination> apiAirports = getAllAirports();
        final List<Destination> cachedAirports = destinationRepository.findAll();

        final Map<String, Destination> cachedAirportsMap = cachedAirports
                .stream().collect(Collectors.toMap(Destination::getCode, item -> item));

        final Map<String, Destination> apiAirportsMap = apiAirports
                .stream().collect(Collectors.toMap(Destination::getCode, item -> item));
        addAirports(cachedAirportsMap, apiAirportsMap);
        deleteAirports(cachedAirportsMap, apiAirportsMap);
    }

    private void addAirports(final Map<String, Destination> cachedAirportsMap,
                             final Map<String, Destination> apiAirportsMap) {
        apiAirportsMap.keySet().removeAll(cachedAirportsMap.keySet());
        destinationRepository.saveAll(apiAirportsMap.values());
    }

    private void deleteAirports(final Map<String, Destination> cachedAirportsMap,
                                final Map<String, Destination> apiAirportsMap) {
        cachedAirportsMap.keySet().removeAll(apiAirportsMap.keySet());
        destinationRepository.deleteAll(cachedAirportsMap.values());
    }
}
