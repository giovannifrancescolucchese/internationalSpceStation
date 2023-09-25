package org.example.model;

import org.example.exception.HealthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LifeParameterTest {

    @Test
    @DisplayName("GIVEN un astronauta qualsiasi WHEN frequenza cardiaca > 180 THEN throw exception")
    void isOutOfRangeHeartBeatRateNow() {
        // arrange
        LifeParameter lifeParameter1 = new LifeParameter(LocalDateTime.now(), null, 100);
        //act and assert
        assertThrows(HealthException.class, () -> lifeParameter1.setHeartRate(190));
    }
}
