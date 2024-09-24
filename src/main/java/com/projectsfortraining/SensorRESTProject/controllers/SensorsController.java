package com.projectsfortraining.SensorRESTProject.controllers;

import com.projectsfortraining.SensorRESTProject.dto.SensorDTO;
import com.projectsfortraining.SensorRESTProject.models.Sensor;
import com.projectsfortraining.SensorRESTProject.services.SensorService;
import com.projectsfortraining.SensorRESTProject.utils.ErrorTextBuilder;
import com.projectsfortraining.SensorRESTProject.utils.exceptions.IncorrectSensorNameException;
import com.projectsfortraining.SensorRESTProject.utils.exceptions.SensorException;
import com.projectsfortraining.SensorRESTProject.utils.responses.SensorErrorResponse;
import com.projectsfortraining.SensorRESTProject.utils.validators.SensorValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final ModelMapper modelMapper;
    private final SensorService sensorService;

    private final SensorValidator sensorValidator;

    public SensorsController(ModelMapper modelMapper, SensorService sensorService, SensorValidator sensorValidator) {
        this.modelMapper = modelMapper;
        this.sensorService = sensorService;
        this.sensorValidator = sensorValidator;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> register(@RequestBody @Valid SensorDTO sensorDTO,
                                               BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            String errorMessage = ErrorTextBuilder.build(bindingResult);
            throw new IncorrectSensorNameException(errorMessage);
        }

        Sensor newSensor = modelMapper.map(sensorDTO, Sensor.class);
        sensorValidator.validate(newSensor,bindingResult);

        sensorService.save(newSensor);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<SensorErrorResponse> handleException (SensorException e){
        SensorErrorResponse response = new SensorErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, e.getHttpStatus());
    }
}
