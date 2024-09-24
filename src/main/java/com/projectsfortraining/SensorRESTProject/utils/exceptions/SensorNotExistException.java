package com.projectsfortraining.SensorRESTProject.utils.exceptions;

import org.springframework.http.HttpStatus;

public class SensorNotExistException extends MeasurementException {
    public SensorNotExistException(){
        this.setMessage("Указанный в измерениях сенсор не найден");
        this.setHttpStatus(HttpStatus.BAD_REQUEST);
    }
}
