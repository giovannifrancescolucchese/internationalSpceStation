package org.example.service;

import org.example.enums.AgenziaSpaziale;
import org.example.model.Astronauta;
import org.example.model.Modulo;
import org.example.model.Vettore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
public class VettoreServiceImplTest {

    @Test
    @DisplayName("GIVEN un modulo da aggiungere WHEN i moduli della stessa agenzia spaziale raggiungono il 50% THEN non posso aggiungere il modulo della stessa agenzia ")
    void canAddModulo(){

        VettoreServiceImpl vettoreService = new VettoreServiceImpl();

        Modulo modulo = Mockito.mock(Modulo.class);
        Modulo modulo1 = Mockito.mock(Modulo.class);
        Modulo modulo2 = Mockito.mock(Modulo.class);

        Vettore vettore = Mockito.mock((Vettore.class));

        Mockito.when(modulo.getAgenziaSpaziale()).thenReturn(AgenziaSpaziale.NASA);
        Mockito.when(modulo1.getAgenziaSpaziale()).thenReturn(AgenziaSpaziale.NASA);
        Mockito.when(modulo2.getAgenziaSpaziale()).thenReturn(AgenziaSpaziale.NASA);
        Mockito.when(vettore.getAgenziaSpaziale()).thenReturn(AgenziaSpaziale.NASA);


        Mockito.when(vettore.getModuli()).thenReturn(List.of(modulo1, modulo2));

        assertFalse(vettoreService.canAddModulo(vettore,modulo));
    }
}
