package org.example.utils;

import org.example.enums.AgenziaSpaziale;
import org.example.enums.CompitoAstronauta;
import org.example.enums.Nazionalita;
import org.example.model.Astronauta;
import org.example.model.LifeParameter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PressureMatrixTest {
    List<LifeParameter> lifeParameterList;
    List<LifeParameter>lifeParameterList2;

    @BeforeEach
    void reArrangeLifeParameterList() {
        lifeParameterList = new ArrayList<>();
        LifeParameter lifeParameter1 = new LifeParameter(LocalDateTime.now(), 100, null);
        LifeParameter lifeParameter2 = new LifeParameter(LocalDateTime.now(), 80, null);
        LifeParameter lifeParameter3 = new LifeParameter(LocalDateTime.now(), 90, null);
        lifeParameterList.add(lifeParameter1);
        lifeParameterList.add(lifeParameter2);
        lifeParameterList.add(lifeParameter3);

        lifeParameterList2 = new ArrayList<>();
        LifeParameter lifeParameter4 = new LifeParameter(LocalDateTime.now(), 150, null);
        LifeParameter lifeParameter5 = new LifeParameter(LocalDateTime.now(), 160, null);
        LifeParameter lifeParameter6 = new LifeParameter(LocalDateTime.now(), 140, null);
        lifeParameterList2.add(lifeParameter4);
        lifeParameterList2.add(lifeParameter5);
        lifeParameterList2.add(lifeParameter6);
    }

    @Test
    @DisplayName("Given un austronauta femmina 30 anni con pressione ultimo giorno a 90 WHEN  isNotOutOfRangePressureInOneDay THEN true")
    void isNotOutOfRangePressureInOneDay() {
        Astronauta astronauta = new Astronauta("", "", LocalDate.now().minusYears(30L),
                Arrays.asList(CompitoAstronauta.MEDICO), 'F', Nazionalita.russa, AgenziaSpaziale.RKA, lifeParameterList);
        PressureMatrix pressureMatrix = new PressureMatrix(astronauta);
        //act
        boolean result = !pressureMatrix.isOutOfRangePressureInOneDay();
        //assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Given un austronauta maschio 40 anni con pressione ultimo giorno a 150 WHEN  isOutOfRangePressureInOneDay THEN true")
    void isOutOfRangePressureInOneDay() {
        Astronauta astronauta = new Astronauta("", "", LocalDate.now().minusYears(40L),
                Arrays.asList(CompitoAstronauta.CO_PILOTA), 'M', Nazionalita.canadese, AgenziaSpaziale.CSA_ASC, lifeParameterList2);
        PressureMatrix pressureMatrix = new PressureMatrix(astronauta);
        //act
        boolean result = pressureMatrix.isOutOfRangePressureInOneDay();
        //assert
        assertTrue(result);
    }
}

//OK..BVA magari facevi dei test a tappeto