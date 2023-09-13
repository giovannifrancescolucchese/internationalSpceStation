package org.example.model;

import org.example.exception.HealthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LifeParameterTest {

    @Test
    @DisplayName("GIVEN life parameter WHEN heart rate is 60 THEN get heart rate is 60")
    void setHeartRate() throws HealthException {
        // Arrange
        LifeParameter lifeParameter = new LifeParameter(LocalDateTime.now(), 0, 0);

        // Act
        lifeParameter.setHeartRate(60);

        // Assert
        assertEquals(60, lifeParameter.getHeartRate());

        //BANALE, si poteva anche non testare
    }
}