package com.projectsfortraining.SensorRESTProject.repositories;

import com.projectsfortraining.SensorRESTProject.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    int findMeasurementsByRainingTrue();
}
