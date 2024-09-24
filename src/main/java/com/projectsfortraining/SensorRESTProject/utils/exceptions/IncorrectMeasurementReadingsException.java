package com.projectsfortraining.SensorRESTProject.utils.exceptions;

import org.springframework.http.HttpStatus;

public class IncorrectMeasurementReadingsException extends MeasurementException {
    public IncorrectMeasurementReadingsException(String message){
        this.setMessage(message);
        this.setHttpStatus(HttpStatus.BAD_REQUEST);
    }
}
