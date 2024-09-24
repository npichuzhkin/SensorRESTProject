package com.projectsfortraining.SensorRESTProject.services;

import com.projectsfortraining.SensorRESTProject.models.Measurement;
import com.projectsfortraining.SensorRESTProject.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MeasurementService {
    private final MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }
    @Transactional
    public void save(Measurement newMeasurement){
        newMeasurement.setMeasuredAt(LocalDateTime.now());
        measurementRepository.save(newMeasurement);
    }

    public List<Measurement> findAll(){
        return measurementRepository.findAll();
    }

    public int countRainyDays(){
        return measurementRepository.findMeasurementsByRainingTrue();
    }
}
