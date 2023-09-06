package org.example.utils;

import org.example.enums.AgenziaSpaziale;
import org.example.enums.CompitoAstronauta;
import org.example.enums.Nazionalita;
import org.example.model.Astronauta;
import org.example.model.LifeParameter;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeartBeatMatrixTest {
    List<LifeParameter> lifeParameterList;

    void reArrangeLifeParameterList(int avgHeartRate) {
        lifeParameterList = new ArrayList<>();
        LifeParameter lifeParameter1 = new LifeParameter(LocalDateTime.now(), null, avgHeartRate);
        LifeParameter lifeParameter2 = new LifeParameter(LocalDateTime.now().minusMinutes(1), null, avgHeartRate);
        lifeParameterList.add(lifeParameter1);
        lifeParameterList.add(lifeParameter2);
    }

    @ParameterizedTest(name = "GIVEN an Astronaut whose gender is {0} and is {1} years old and had and average heartbeat of {2} in the last 7 minutes, WHEN: isOutOfRangeHearBeatLast7Minutes, THEN: {3}")
    @CsvSource({"F, 25, 100, true",
            "M, 25, 100, true",
            "F, 25, 60, false",
            "M, 25, 60, false",
            "F, 35, 100, true",
            "M, 35, 100, true",
            "F, 35, 60, false",
            "M, 35, 60, false",})
    void isOutOfRangeHeartBeatLast7Minutes(char gender, int age, int avgHeartBeat, boolean expectedResult) {
        //arrange;
        reArrangeLifeParameterList(avgHeartBeat);
        Astronauta astronauta = new Astronauta("", "", LocalDate.now().minusYears(age),
                Arrays.asList(CompitoAstronauta.BIOLOGO), gender, Nazionalita.americana, AgenziaSpaziale.NASA, lifeParameterList);
        HeartBeatMatrix heartBeatMatrix = new HeartBeatMatrix(astronauta);
        //act
        boolean result = heartBeatMatrix.isOutOfRangeHeartBeatLast7Minutes();
        //assert
        assertEquals(result, expectedResult);
    }

}