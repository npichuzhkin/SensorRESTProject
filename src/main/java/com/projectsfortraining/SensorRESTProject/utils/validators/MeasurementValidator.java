package com.projectsfortraining.SensorRESTProject.utils.validators;

import com.projectsfortraining.SensorRESTProject.models.Measurement;
import com.projectsfortraining.SensorRESTProject.services.MeasurementService;
import com.projectsfortraining.SensorRESTProject.services.SensorService;
import com.projectsfortraining.SensorRESTProject.utils.exceptions.SensorNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {
    private final SensorService sensorService;

    @Autowired
    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;

        if (!sensorService.sensorIsExist(measurement.getSensor())){
            errors.rejectValue("sensor","","Указанный в измерениях сенсор не найден");
            throw new SensorNotExistException();
        }
    }
}
