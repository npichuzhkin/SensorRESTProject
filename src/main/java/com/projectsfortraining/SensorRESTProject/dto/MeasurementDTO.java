package com.projectsfortraining.SensorRESTProject.dto;

import com.projectsfortraining.SensorRESTProject.models.Sensor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MeasurementDTO {

    private SensorDTO sensor;

    @Min(value = -100, message = "Минимальная температура: -100")
    @Max(value = 100, message = "Максимальная температура: 100")
    private double value;

    private boolean raining;

    private LocalDateTime measuredAt;
}
