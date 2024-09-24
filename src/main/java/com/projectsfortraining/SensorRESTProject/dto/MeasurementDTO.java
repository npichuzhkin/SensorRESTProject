package com.projectsfortraining.SensorRESTProject.dto;

import com.projectsfortraining.SensorRESTProject.models.Sensor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MeasurementDTO {
    @NotEmpty(message = "Измерение должно иметь информацию о сенсоре")
    private Sensor sensor;

    @NotEmpty(message = "Температура воздуха (value) должна быть заполнена")
    @Min(value = -100, message = "Минимальная температура: -100")
    @Max(value = 100, message = "Максимальная температура: 100")
    private boolean value;

    @NotEmpty(message = "Поле raining должно быть заполнено значением true или false")
    private boolean raining;

    private LocalDateTime measuredAt;
}
