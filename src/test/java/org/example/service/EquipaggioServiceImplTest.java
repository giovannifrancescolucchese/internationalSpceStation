package org.example.service;

import org.example.enums.AgenziaSpaziale;
import org.example.model.Astronauta;
import org.example.model.BaseSpaziale;
import org.example.model.Equipaggio;
import org.example.model.Vettore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class EquipaggioServiceImplTest {

    @Test
    @DisplayName("GIVEN: an equipaggio with at least several women, WHEN: atLeast1Woman, THEN: true")
    void atLeast1Woman() {
        //ARRANGE
        Astronauta astronauta = Mockito.mock(Astronauta.class);
        Mockito.when(astronauta.getSesso()).thenReturn('F');
        List<Astronauta> astronauts = new ArrayList<>();
        astronauts.add(astronauta);
        Equipaggio equipaggio = new Equipaggio(astronauts, astronauta, astronauta);
        EquipaggioServiceImpl equipaggioService = new EquipaggioServiceImpl();
        //ACT
        boolean result = equipaggioService.atLeast1Woman(equipaggio);
        //ASSERT
        assertTrue(result);
    }

    @Test
    @DisplayName("GIVEN: an equipaggio with 0 women, WHEN: atLeast1Woman, THEN: false")
    void atLeast1WomanFalse() {
        //ARRANGE
        Astronauta astronauta = Mockito.mock(Astronauta.class);
        Mockito.when(astronauta.getSesso()).thenReturn('M');
        List<Astronauta> astronauts = new ArrayList<>();
        astronauts.add(astronauta);
        Equipaggio equipaggio = new Equipaggio(astronauts, astronauta, astronauta);
        EquipaggioServiceImpl equipaggioService = new EquipaggioServiceImpl();
        //ACT
        boolean result = equipaggioService.atLeast1Woman(equipaggio);
        //ASSERT
        assertFalse(result);
    }

    //OK

    @Test
    @DisplayName("GIVEN: An equipaggio with 2 members of different space agencies, WHEN; trying to check a third astronaut with atLeast70percNoSameSpaceAncy, THEN; true, due to it being either 33%,33%,33%, or 66% and 33%")
    void atLeast70percNoSameSpaceAncy() {
        //ARRANGE
        Astronauta astronauta = Mockito.mock(Astronauta.class);
        Mockito.when(astronauta.getAgenziaSpaziale()).thenReturn(AgenziaSpaziale.NASA);
        Astronauta astronauta1 = Mockito.mock(Astronauta.class);
        Mockito.when(astronauta1.getAgenziaSpaziale()).thenReturn(AgenziaSpaziale.ESA);
        List<Astronauta> equipaggioAstronauti = new ArrayList<>();
        equipaggioAstronauti.add(astronauta);
        equipaggioAstronauti.add(astronauta1);
        Equipaggio equipaggio = new Equipaggio(equipaggioAstronauti, astronauta, astronauta1);
        EquipaggioServiceImpl equipaggioService = new EquipaggioServiceImpl();
        //ACT
        boolean result = equipaggioService.atLeast70percNoSameSpaceAncy(equipaggio, astronauta);
        //ASSERT
        assertTrue(result);
    }

    @Test
    @DisplayName("GIVEN: An equipaggio with 3 members of same space agencies, WHEN; trying to check a third astronaut with atLeast70percNoSameSpaceAncy, THEN; false, due to it being 80% and 20%")
    void atLeast70percNoSameSpaceAncyFALSE() {
        //ARRANGE
        Astronauta astronauta = Mockito.mock(Astronauta.class);
        Mockito.when(astronauta.getAgenziaSpaziale()).thenReturn(AgenziaSpaziale.NASA);
        Astronauta astronauta1 = Mockito.mock(Astronauta.class);
        Mockito.when(astronauta1.getAgenziaSpaziale()).thenReturn(AgenziaSpaziale.NASA);
        Astronauta astronauta2 = Mockito.mock(Astronauta.class);
        Mockito.when(astronauta2.getAgenziaSpaziale()).thenReturn(AgenziaSpaziale.NASA);
        List<Astronauta> equipaggioAstronauti = new ArrayList<>();
        equipaggioAstronauti.add(astronauta);
        equipaggioAstronauti.add(astronauta1);
        equipaggioAstronauti.add(astronauta2);
        Equipaggio equipaggio = new Equipaggio(equipaggioAstronauti, astronauta, astronauta1);
        EquipaggioServiceImpl equipaggioService = new EquipaggioServiceImpl();
        //ACT
        boolean result = equipaggioService.atLeast70percNoSameSpaceAncy(equipaggio, astronauta);
        //ASSERT
        assertFalse(result);
    }

//    @Test
//    void canAddAstronauta() {
//        //ARRANGE
//        List<Astronauta> equipaggioAstronauti = new ArrayList<>();
//        for (int x = 1; x <= 3; x++) {
//        Astronauta astronauta = Mockito.mock(Astronauta.class);
//        Mockito.when(astronauta.getAgenziaSpaziale()).thenReturn(AgenziaSpaziale.NASA);
//        equipaggioAstronauti.add(astronauta);}
//        Astronauta astronautaCap = Mockito.mock(Astronauta.class)
//        Equipaggio equipaggioVettoreMock = new Equipaggio(equipaggioAstronauti, astronautaCap, astronautaCap);
//        Vettore vettore = Mockito.mock(Vettore.class);
//        Mockito.when(vettore.getEquipaggio()).thenReturn(equipaggioVettoreMock);
//
//        BaseSpaziale baseSpaziale = Mockito.mock(BaseSpaziale.class;
//        Mockito.when(baseSpaziale.getPostiLetto()).thenReturn(10);
//        Mockito.when(baseSpaziale.getPostiLetto()).thenReturn(10);
//    }
}