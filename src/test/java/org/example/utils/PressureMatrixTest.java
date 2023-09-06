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


    @ParameterizedTest(name = "Given {0} gender, {1} age  And {2} average pressure in 24 hours . Then his pressure is out of range : {3}  ")
    @CsvSource({
            "F, 20, 59, True",
            "F, 20, 60, False",
            "F, 20, 140, False",
            "F, 20, 141, True",
            "F, 51, 86, True",
            "F, 51, 87, False",
            "F, 51, 135, False",
            "F, 51, 136, True",
            "M, 31, 74, True",
            "M, 31, 75, False",
            "M, 31, 125, False",
            "M, 31, 126, True",
            "M, 59, 86, True",
            "M, 59, 87, False",
            "M, 59, 130, False",
            "M, 59, 131, True"
    })
    void givenGenderAgeAndAveragePressureWhenIsOutOfRange(char gender, int age, int pressure, boolean expectedResult) {

        reArrangeLifeParameterList(pressure);
        Astronauta astronauta = new Astronauta("", "", LocalDate.now().minusYears(age),
                Arrays.asList(CompitoAstronauta.BIOLOGO), gender, Nazionalita.francese, AgenziaSpaziale.RKA, lifeParameterList);

        PressureMatrix pressureMatrix = new PressureMatrix(astronauta);

        boolean result = pressureMatrix.isOutOfRangePressureInOneDay();

        assertEquals(result, expectedResult);
    }

//    @Test
//    @DisplayName("GIVEN un astronauta femmina di 20 anni con ultimi 25 ore media di presione a 59 WHEN isOutOfRangePressureInOneDay THEN true")
//    void isOutOfRangePressureLast24Hours() {
//        Astronauta astronauta = new Astronauta("", "", LocalDate.now().minusYears(20),
//                Arrays.asList(CompitoAstronauta.PILOTA), 'F', Nazionalita.francese, AgenziaSpaziale.CSA_ASC, lifeParameterList);
//        PressureMatrix pressureMatrix = new PressureMatrix(astronauta);
//        boolean result = pressureMatrix.isOutOfRangePressureInOneDay();
//
//        assertTrue(result);
//    }

}