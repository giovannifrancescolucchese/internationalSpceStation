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

class HeartBeatMatrixTest {
    List<LifeParameter> lifeParameterList;
    List<LifeParameter>  lifeParameterList2;
    @BeforeEach
    void reArrangeLifeParameterList() {
     lifeParameterList=new ArrayList<>();
     LifeParameter lifeParameter1=new LifeParameter(LocalDateTime.now(),null,100);
     LifeParameter lifeParameter2=new LifeParameter(LocalDateTime.now().minusMinutes(1),null,100);
     lifeParameterList.add(lifeParameter1);
     lifeParameterList.add(lifeParameter2);

        lifeParameterList2 = new ArrayList<>();
        LifeParameter lifeParameter4 = new LifeParameter(LocalDateTime.now(), null, 70);
        LifeParameter lifeParameter5 = new LifeParameter(LocalDateTime.now(), null, 60);
        LifeParameter lifeParameter6 = new LifeParameter(LocalDateTime.now(), null, 80);
        lifeParameterList2.add(lifeParameter4);
        lifeParameterList2.add(lifeParameter5);
        lifeParameterList2.add(lifeParameter6);
    }

    @Test
    @DisplayName("GIVEN un astronauta femmina di 25 anni con ultimi 7 minuti media di battiti a 100 WHEN isOutOfRangeHeartBeatLast7Minutes THEN true")
    void isOutOfRangeHeartBeatLast7Minutes() {
        //arrange

        Astronauta astronauta=new Astronauta("","", LocalDate.now().minusYears(25L),
                Arrays.asList(CompitoAstronauta.BIOLOGO),  'F', Nazionalita.americana, AgenziaSpaziale.NASA, lifeParameterList);
        HeartBeatMatrix heartBeatMatrix=new HeartBeatMatrix(astronauta);
        //act
        boolean result=heartBeatMatrix.isOutOfRangeHeartBeatLast7Minutes();
        //assert
        assertTrue(result);
    } @Test
    @DisplayName("GIVEN un astronauta maschio di 41 anni con ultimi 7 minuti media di battiti a 70 WHEN isNotOutOfRangeHeartBeatLast7Minutes THEN true")
    void isNotOutOfRangeHeartBeatLast7Minutes() {
        //arrange

        Astronauta astronauta=new Astronauta("","", LocalDate.now().minusYears(41L),
                Arrays.asList(CompitoAstronauta.PILOTA),  'F', Nazionalita.giapponese, AgenziaSpaziale.JAXA, lifeParameterList2);
        HeartBeatMatrix heartBeatMatrix=new HeartBeatMatrix(astronauta);
        //act
        boolean result=!heartBeatMatrix.isOutOfRangeHeartBeatLast7Minutes();
        //assert
        assertTrue(result);
    }

//OK, ptevi considerare di utilizzare parametrized test
}