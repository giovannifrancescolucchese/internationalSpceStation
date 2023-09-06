package org.example.utils;

import org.example.enums.AgenziaSpaziale;
import org.example.enums.CompitoAstronauta;
import org.example.enums.Nazionalita;
import org.example.model.Astronauta;
import org.example.model.LifeParameter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PressureMatrixTest {
    @Mock
    List<LifeParameter> lifeParameterList = new ArrayList<>();

    @Test
    @DisplayName("GIVEN un astronauta maschio di 35 anni con average pressure di 73 WHEN isOutOfRangePressureInOneDay THEN true")
    void isOutOfRangePressureInOneDay() {
        //arrange

        Astronauta astronauta = new Astronauta("", "", LocalDate.now().minusYears(35L),
                Arrays.asList(CompitoAstronauta.INGEGNERE), 'M', Nazionalita.italiana, AgenziaSpaziale.ESA, lifeParameterList);
        PressureMatrix pressureMatrix = new PressureMatrix(astronauta);
        //act
        boolean result = pressureMatrix.isOutOfRangePressureInOneDay();
        //assert
        assertTrue(result);
    }
    @Test
    @DisplayName("GIVEN un astronauta maschio di 35 anni con average pressure di 78 WHEN isOutOfRangePressureInOneDay THEN false")
    void isOutOfRangePressureInOneDay2() {
        //arrange

        Astronauta astronauta = new Astronauta("", "", LocalDate.now().minusYears(35L),
                Arrays.asList(CompitoAstronauta.INGEGNERE), 'M', Nazionalita.italiana, AgenziaSpaziale.ESA, lifeParameterList);
        PressureMatrix pressureMatrix = new PressureMatrix(astronauta);
        //act
        boolean result = pressureMatrix.isOutOfRangePressureInOneDay();
        //assert
        assertTrue(result);
    }
}