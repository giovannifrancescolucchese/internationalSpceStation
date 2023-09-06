package org.example.service;

import org.example.enums.AgenziaSpaziale;
import org.example.enums.CompitoAstronauta;
import org.example.enums.Nazionalita;
import org.example.model.Astronauta;
import org.example.model.Equipaggio;
import org.example.model.LifeParameter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EquipaggioServiceImplTest {
    List<LifeParameter> lifeParameterList;
    List<Astronauta> astronautaList;



    @BeforeEach
    void reArrangeLifeParameterList() {
        lifeParameterList = new ArrayList<>();
        LifeParameter lifeParameter1 = new LifeParameter(LocalDateTime.now(), 100, null);
    }

    @Test
    @DisplayName("Given almeno un austronauta femmina  WHEN  atLeastWoman THEN true")
    void atLeast1Woman() {
        //arrenge
        Astronauta astronauta = new Astronauta("", "", LocalDate.now().minusYears(30L),
                Arrays.asList(CompitoAstronauta.CO_PILOTA), 'M', Nazionalita.americana, AgenziaSpaziale.NASA, lifeParameterList);
        Astronauta astronauta2 = new Astronauta("", "", LocalDate.now().minusYears(30L),
                Arrays.asList(CompitoAstronauta.PILOTA), 'F', Nazionalita.italiana, AgenziaSpaziale.ESA, lifeParameterList);
        astronautaList = new ArrayList<>();
        astronautaList.add(astronauta);
        astronautaList.add(astronauta2);

        Equipaggio equipaggio = new Equipaggio(astronautaList, astronauta2, astronauta);
        EquipaggioServiceImpl equipaggioService = new EquipaggioServiceImpl();
        //act
        boolean risultato = equipaggioService.atLeast1Woman(equipaggio);
        //assert
        assertTrue(risultato);
    }

    @Test
    @DisplayName("Given una lista di austronauti When atLeast70percNoSameSpaceAncy THEN true")
    void atLeast70percNoSameSpaceAncy() {

    }

    @Test
    void canAddAstronauta() {
    }
}