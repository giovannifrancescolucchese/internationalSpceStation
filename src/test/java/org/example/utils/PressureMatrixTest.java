package org.example.utils;

import org.example.enums.AgenziaSpaziale;
import org.example.enums.CompitoAstronauta;
import org.example.enums.Nazionalita;
import org.example.model.Astronauta;
import org.example.model.LifeParameter;
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

class PressureMatrixTest {
    List<LifeParameter> lifeParameterList;


    void reArrangeLifeParameterList(int pressure) {
        lifeParameterList = new ArrayList<>();
        LifeParameter lifeParameter1 = new LifeParameter(LocalDateTime.now(), pressure, null);
        LifeParameter lifeParameter2 = new LifeParameter(LocalDateTime.now().minusHours(12), pressure, null);
        lifeParameterList.add(lifeParameter1);
        lifeParameterList.add(lifeParameter2);
    }

    @ParameterizedTest(name = "GIVEN an Astronaut whose gender is {0} and is {1} years old and had and average pressure of {2} in the last 24 hours, WHEN: isOutOfRangePressureInOneDay, THEN: {3}")
    @CsvSource({"F, 25, 200, true",
            "M, 25, 200, true",
            "F, 25, 100, false",
            "M, 25, 100, false",
            "F, 35, 200, true",
            "M, 35, 200, true",
            "F, 35, 100, false",
            "M, 35, 100, false",
            "F, 45, 200, true",
            "M, 45, 200, true",
            "F, 45, 100, false",
            "M, 45, 100, false",
    })
    void isOutOfRangeHeartBeatLast7Minutes(char gender, int age, int pressure, boolean expectedResult) {
        //arrange;
        reArrangeLifeParameterList(pressure);
        Astronauta astronauta = new Astronauta("", "", LocalDate.now().minusYears(age),
                Arrays.asList(CompitoAstronauta.BIOLOGO), gender, Nazionalita.americana, AgenziaSpaziale.NASA, lifeParameterList);
        PressureMatrix pressureMatrix =new PressureMatrix(astronauta);
        //act
        boolean result=pressureMatrix.isOutOfRangePressureInOneDay();
        //assert
        assertEquals(result, expectedResult);

    }
}