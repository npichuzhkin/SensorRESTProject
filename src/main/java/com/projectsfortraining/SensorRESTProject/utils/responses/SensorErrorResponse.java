package com.projectsfortraining.SensorRESTProject.utils.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SensorErrorResponse {
    private String sensorErrorMessage;
    private long sensorErrorTime;

    public SensorErrorResponse(String sensorErrorMessage){
        this.sensorErrorMessage = sensorErrorMessage;
        this.sensorErrorTime = System.currentTimeMillis();

    }
}
