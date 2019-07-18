package com.cleverlance.academy.airlines.repository;

import com.cleverlance.academy.airlines.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlaneRepository extends JpaRepository<Plane, Long> {

    @Query("select plane from Plane plane where plane.registrationCode = :regCode")
    Plane getPlaneByRegistrationCode(@Param("regCode") String registrationCode);
}
