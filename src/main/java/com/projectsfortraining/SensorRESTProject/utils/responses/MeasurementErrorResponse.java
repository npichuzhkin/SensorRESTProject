package com.projectsfortraining.SensorRESTProject.utils.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeasurementErrorResponse {
    private String measurementErrorMessage;
    private long measurementErrorTime;

    public MeasurementErrorResponse(String measurementErrorMessage){
        this.measurementErrorMessage = measurementErrorMessage;
        this.measurementErrorTime = System.currentTimeMillis();
    }
}
