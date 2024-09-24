package com.projectsfortraining.SensorRESTProject.repositories;

import com.projectsfortraining.SensorRESTProject.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    List<Sensor> findByName(String name);
}
