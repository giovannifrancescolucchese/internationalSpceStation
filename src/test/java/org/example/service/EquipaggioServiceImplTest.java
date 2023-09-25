package org.example.service;

import org.example.enums.AgenziaSpaziale;
import org.example.model.Astronauta;
import org.example.model.BaseSpaziale;
import org.example.model.Equipaggio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class EquipaggioServiceImplTest {


    @Test
    @DisplayName("GIVEN n membri equipaggio WHEN 70% membri from same space agency THEN true")
    void isEquipaggioMembersMoreThanBedInSpaceStation(){
        EquipaggioServiceImpl equipaggioServiceImpl = new EquipaggioServiceImpl();


        Astronauta astronauta = Mockito.mock(Astronauta.class);

        Astronauta astronauta1 = Mockito.mock(Astronauta.class);
        Mockito.when(astronauta1.getAgenziaSpaziale()).thenReturn(AgenziaSpaziale.RKA);
        Mockito.when(astronauta.getAgenziaSpaziale()).thenReturn(AgenziaSpaziale.CSA_ASC);


        List<Astronauta> equipaggioAstronauti = new ArrayList<>(List.of(astronauta, astronauta1));

        Equipaggio equipaggio = new Equipaggio(equipaggioAstronauti, astronauta, astronauta1);

        //ACT
        boolean result = equipaggioServiceImpl.atLeast70percNoSameSpaceAncy(equipaggio, astronauta);
        //ASSERT
        assertTrue(result);
    }
}
