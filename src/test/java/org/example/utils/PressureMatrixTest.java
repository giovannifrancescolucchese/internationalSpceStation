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

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PressureMatrixTest {
    List<LifeParameter> lifeParameterList;

    @BeforeEach
    void reArrangeLifeParameterList() {
        lifeParameterList = new ArrayList<>();
        LifeParameter lifeParameter1 = new LifeParameter(LocalDateTime.now(), 50, null);
        LifeParameter lifeParameter2 = new LifeParameter(LocalDateTime.now().plusDays(1), 50, null);
        lifeParameterList.add(lifeParameter1);
        lifeParameterList.add(lifeParameter2);
    }

    @Test
    @DisplayName("GIVEN un astronauta femmina di eta 20-30 WHEN ha pressione fuori dal range 60-140 per più di un giorno THEN true")
    void isOutOfRangePressionLastTwoDays() {
        // come dico che sono due giorni di fila o che è passato un girono?
        //arrange
        Astronauta astronauta=new Astronauta("","", LocalDate.now().minusYears(25L),
                Arrays.asList(CompitoAstronauta.BIOLOGO),  'F', Nazionalita.americana, AgenziaSpaziale.NASA, lifeParameterList);
        PressureMatrix pressureMatrix=new PressureMatrix(astronauta);
        //act
        boolean result=pressureMatrix.isOutOfRangePressureInOneDay();


        //assert
        assertTrue(result);

    }

}
