package com.projectsfortraining.SensorRESTProject.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SensorDTO {

    @NotEmpty(message = "Сенсор должен иметь название")
    @Size(min = 3, max = 30, message = "Название должно содержать от 3 до 30 символов")
    private String name;
}
