package com.projectsfortraining.SensorRESTProject.controllers;

import com.projectsfortraining.SensorRESTProject.dto.MeasurementDTO;
import com.projectsfortraining.SensorRESTProject.models.Measurement;
import com.projectsfortraining.SensorRESTProject.models.Sensor;
import com.projectsfortraining.SensorRESTProject.services.MeasurementService;
import com.projectsfortraining.SensorRESTProject.services.SensorService;
import com.projectsfortraining.SensorRESTProject.utils.ErrorTextBuilder;
import com.projectsfortraining.SensorRESTProject.utils.exceptions.IncorrectMeasurementReadingsException;
import com.projectsfortraining.SensorRESTProject.utils.exceptions.MeasurementException;
import com.projectsfortraining.SensorRESTProject.utils.exceptions.SensorNotExistException;
import com.projectsfortraining.SensorRESTProject.utils.responses.MeasurementErrorResponse;
import com.projectsfortraining.SensorRESTProject.utils.validators.MeasurementValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementsController {
    private final ModelMapper modelMapper;
    private final MeasurementService measurementService;
    private final SensorService sensorService;
    private final MeasurementValidator measurementValidator;

    @Autowired
    public MeasurementsController(ModelMapper modelMapper, MeasurementService measurementService, SensorService sensorService, MeasurementValidator measurementValidator) {
        this.modelMapper = modelMapper;
        this.measurementService = measurementService;
        this.sensorService = sensorService;
        this.measurementValidator = measurementValidator;
    }

    @GetMapping
    public List<MeasurementDTO> getAllMeasurements(){
        List<Measurement> measurements = measurementService.findAll();
        List<MeasurementDTO> result = new LinkedList<>(Collections.emptyList());

        for (Measurement m: measurements) {
            result.add(modelMapper.map(m, MeasurementDTO.class));
        }

        return result;
    }

    @GetMapping("/rainyDaysCount")
    public String countRainyDays(){
        return "Дождливых дней: " + measurementService.countRainyDays();
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementDTO measurementDTO,
                                                     BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            String errorMessage = ErrorTextBuilder.build(bindingResult);
            throw new IncorrectMeasurementReadingsException(errorMessage);
        }

        Measurement newMeasurement = modelMapper.map(measurementDTO, Measurement.class);
        measurementValidator.validate(newMeasurement,bindingResult);
        newMeasurement.setSensor(sensorService.findByName(measurementDTO.getSensor().getName()).get(0));

        measurementService.save(newMeasurement);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<MeasurementErrorResponse> handleException(MeasurementException e){
        MeasurementErrorResponse response = new MeasurementErrorResponse(e.getMessage());
        return new ResponseEntity<>(response,e.getHttpStatus());
    }
}
