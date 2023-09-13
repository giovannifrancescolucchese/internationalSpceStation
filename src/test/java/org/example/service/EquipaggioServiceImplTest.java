package org.example.service;


import org.example.enums.AgenziaSpaziale;
import org.example.enums.CompitoAstronauta;
import org.example.enums.Nazionalita;
import org.example.model.Astronauta;
import org.example.model.Equipaggio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EquipaggioServiceImplTest {


    @Test
    @DisplayName("Created crew with one woman , then atLeast1Woman should return true")
    void givenCrewWithWomanInsideThenCheckAtLeast1WomanWhenTrue() {

        EquipaggioService equipaggioService = new EquipaggioServiceImpl();

        List<Astronauta> astronautaList = new ArrayList<>();
        Astronauta mary = new Astronauta("", "", LocalDate.now(), null, 'F', Nazionalita.americana, AgenziaSpaziale.NASA, null);
        astronautaList.add(mary);

        Equipaggio equipaggio = new Equipaggio(astronautaList, null, null);

        boolean result = equipaggioService.atLeast1Woman(equipaggio);

        assertTrue(result);
    }

    @Test
    @DisplayName("Created crew with no woman , then atLeast1Woman should return false")
    void givenCrewWithNoWomanInsideThenCheckAtLeast1WomanWhenFalse() {

        EquipaggioService equipaggioService = new EquipaggioServiceImpl();

        List<Astronauta> astronautaList = new ArrayList<>();
        Astronauta bob = new Astronauta("", "", LocalDate.now(), null, 'M', Nazionalita.americana, AgenziaSpaziale.NASA, null);
        astronautaList.add(bob);

        Equipaggio equipaggio = new Equipaggio(astronautaList, null, null);

        boolean result = equipaggioService.atLeast1Woman(equipaggio);

        assertFalse(result);
    }


    @Test
    @DisplayName("Create crew with the same space ancy more than 70 % then atLeast70PercentNoSameSpaceAncy shold return false")
    void givenCrewWithSameSpaceAncyThenCheckAtLeast70PercetNoSameSpaceAncyReturnFalse() {

        EquipaggioService equipaggioService = new EquipaggioServiceImpl();
        List<Astronauta> astronautaList = new ArrayList<>();


        Astronauta homer = new Astronauta("", "", LocalDate.now(), null, 'M', Nazionalita.americana, AgenziaSpaziale.NASA, null);
        Astronauta marge = new Astronauta("", "", LocalDate.now(), null, 'F', Nazionalita.americana, AgenziaSpaziale.NASA, null);
        Astronauta bart = new Astronauta("", "", LocalDate.now(), null, 'M', Nazionalita.americana, AgenziaSpaziale.NASA, null);


        astronautaList.add(homer);
        astronautaList.add(marge);

        Equipaggio equipaggio = new Equipaggio(astronautaList, null, null);

        boolean result = equipaggioService.atLeast70percNoSameSpaceAncy(equipaggio, bart);
        assertFalse(result);

    }

//OK
}