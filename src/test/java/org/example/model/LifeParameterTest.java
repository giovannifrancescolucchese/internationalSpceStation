package org.example.model;

import org.example.exception.HealthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class LifeParameterTest {

    @ParameterizedTest(name = "GIVEN: An instance of lifeParameter WHEN: Setting normal heart rate, THEN: Heart Rate shouldnt throw any exception")
    @CsvSource({
            "100",
            "110",
            "179"
    })
    void setHeartRateTest(Integer heartRate) throws HealthException {
        //ASSERT
        LifeParameter lifeParameter = new LifeParameter();
        //ACT
        lifeParameter.setHeartRate(heartRate);
        //ASSERT
        assertEquals(heartRate, lifeParameter.getHeartRate());
    }


    @ParameterizedTest(name = "GIVEN: An instance of lifeParameter WHEN: Setting abnormaly high heart rate, THEN: Heart Rate should throw an exception")
    @CsvSource({
            "180",
            "190",
            Integer.MAX_VALUE + "",
            Integer.MAX_VALUE-1 + "",
    })
    void setHeartRateExceptionTest(Integer heartRate)    {
        //ASSERT
        Exception catchedException = null;
        LifeParameter lifeParameter = new LifeParameter();
        //ACT
        try {
            lifeParameter.setHeartRate(heartRate);
        }catch (HealthException e) {
            catchedException = e;
        }
        //ASSERT
        assertEquals(catchedException.getClass(),HealthException.class);
    }
}