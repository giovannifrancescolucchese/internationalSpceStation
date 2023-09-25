package org.example.service;

import org.example.model.Astronauta;
import org.example.model.Equipaggio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VettoreServiceImplTest {
   @Test
    void atlast1WomanTest(){
       Astronauta astronauta= Mockito.mock(Astronauta.class);
       Mockito.when(astronauta.getSesso()).thenReturn('F');
       List<Astronauta> astronautaList =new ArrayList<>();
       astronautaList.add(astronauta);
       Equipaggio equipaggio = new Equipaggio(astronautaList,astronauta,astronauta);
       EquipaggioServiceImpl equipaggioService = new EquipaggioServiceImpl();

       boolean reault= equipaggioService.atLeast1Woman(equipaggio);
       assertTrue(reault);
   }
}