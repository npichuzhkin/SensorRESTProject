package com.projectsfortraining.SensorRESTProject.utils.exceptions;

import org.springframework.http.HttpStatus;

public class IncorrectSensorNameException extends SensorException {
    public IncorrectSensorNameException(String message){
        this.setMessage(message);
        this.setHttpStatus(HttpStatus.BAD_REQUEST);
    }
}
