package com.projectsfortraining.SensorRESTProject.utils.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class MeasurementException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    void setMessage(String message){
        this.message = message;
    }
    void setHttpStatus(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }
}
