package com.projectsfortraining.SensorRESTProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.aspectj.bridge.IMessage;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "measurement")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;

    @Min(value = -100, message = "Минимальная температура: -100")
    @Max(value = 100, message = "Максимальная температура: 100")
    @Column(name = "value")
    private double value;

    @Column(name = "raining")
    private boolean raining;

    @Column(name = "measured_at")
    private LocalDateTime measuredAt;
}
