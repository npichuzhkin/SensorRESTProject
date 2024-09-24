package com.projectsfortraining.SensorRESTProject.services;

import com.projectsfortraining.SensorRESTProject.models.Sensor;
import com.projectsfortraining.SensorRESTProject.repositories.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> findAll(){
        return sensorRepository.findAll();
    }

    public List<Sensor> findByName(String name){
        return sensorRepository.findByName(name);
    }
    @Transactional
    public void save(Sensor newSensor){
        sensorRepository.save(newSensor);
    }

    public boolean sensorIsExist(Sensor sensor){
        return !(findByName(sensor.getName()).isEmpty());
    }
}
