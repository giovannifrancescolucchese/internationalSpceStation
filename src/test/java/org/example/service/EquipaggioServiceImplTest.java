package org.example.service;

import org.example.enums.AgenziaSpaziale;
import org.example.enums.CompitoAstronauta;
import org.example.enums.Nazionalita;
import org.example.model.Astronauta;
import org.example.model.Equipaggio;
import org.example.model.LifeParameter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EquipaggioServiceImplTest {

    @Mock
    Astronauta capitano;
    Astronauta vice_capitano;

    List<LifeParameter> lifeParameterList;
    List<CompitoAstronauta> compitoAstronautaList;

    @Test
    @DisplayName("GIVEN 0 woman in the equiment WHEN atLeast1Woman THEN false")
    void atLeast1Woman() {
        //arrange
        List<Astronauta> astronautaList = new ArrayList<>();
        Astronauta a = new Astronauta("", "", LocalDate.now(), compitoAstronautaList, 'M', Nazionalita.americana, AgenziaSpaziale.NASA, lifeParameterList);
        astronautaList.add(a);
        Equipaggio equipaggio = new Equipaggio(astronautaList, capitano, vice_capitano);
        EquipaggioServiceImpl equipaggioService = new EquipaggioServiceImpl();
        //act
        boolean result = equipaggioService.atLeast1Woman(equipaggio);
        //assert
        assertFalse(result);
    }
}