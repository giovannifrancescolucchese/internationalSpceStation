package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.exception.HealthException;

import java.time.LocalDateTime;

/**
 * The {@code LifeParameter} class represents a model for capturing vital signs at a specific moment.
 * This class includes information about the blood pressure and heart rate, along with a timestamp.
 * It's designed to monitor health metrics over time and can throw an exception if a critical health condition is detected.
 *
 * @author
 * @version 1.0
 * @since 2023-04-01
 */
@Data // Lombok annotation for generating boilerplate code: getters, setters, toString, equals, and hashCode.
@AllArgsConstructor // Lombok annotation to generate a constructor with all parameters.
public class LifeParameter {
    LocalDateTime timestamp; // Timestamp representing the moment these measurements were taken.
    Integer pressure; // Blood pressure measurement.
    Integer heartRate; // Heart rate measurement.

    /**
     * Sets the heart rate and throws an exception if the value indicates a potential health risk.
     *
     * @param heartRate The heart rate value to set.
     * @throws HealthException If the heart rate is equal to or higher than 180, indicating a potential heart attack.
     */
    public void setHeartRate(Integer heartRate) throws HealthException {
        this.heartRate = heartRate;
        // Check if the heart rate is critically high, indicating a potential heart attack risk.
        if (heartRate >= 180) {
            throw new HealthException("pericolo infarto");
        }
    }
}