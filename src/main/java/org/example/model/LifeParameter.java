package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.exception.HealthException;
import org.example.exception.ISSException;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class LifeParameter {
    LocalDateTime timestamp;
    Integer pressure;
    Integer heartRate;

    public void setHeartRate(Integer heartRate) throws HealthException {
        this.heartRate = heartRate;
        if (heartRate>=180) throw new HealthException("pericolo infarto");
    }
}
