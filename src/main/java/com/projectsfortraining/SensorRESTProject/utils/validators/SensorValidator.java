package com.projectsfortraining.SensorRESTProject.utils.validators;

import com.projectsfortraining.SensorRESTProject.models.Sensor;
import com.projectsfortraining.SensorRESTProject.services.SensorService;
import com.projectsfortraining.SensorRESTProject.utils.exceptions.SensorAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SensorValidator implements Validator {

    private final SensorService sensorService;

    @Autowired
    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;
        if (sensorService.sensorIsExist(sensor)){
            errors.rejectValue("name","", "Сенсор с таким именем уже существует");
            throw new SensorAlreadyExistsException();
        }
    }
}
