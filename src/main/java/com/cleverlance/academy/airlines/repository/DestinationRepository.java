package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
