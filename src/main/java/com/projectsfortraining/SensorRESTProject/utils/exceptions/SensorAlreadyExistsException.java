package com.projectsfortraining.SensorRESTProject.utils.exceptions;

import org.springframework.http.HttpStatus;

public class SensorAlreadyExistsException extends SensorException{
    public SensorAlreadyExistsException(){
        this.setMessage("Сенсор с таким названием уже существует");
        this.setHttpStatus(HttpStatus.BAD_REQUEST);
    }
}
