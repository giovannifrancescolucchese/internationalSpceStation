package org.example.service;

import org.example.model.BaseSpaziale;
import org.example.model.Comunication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ComuncationServiceImplTest {

    @Mock
    BaseSpazialeService baseSpazialeService;

    @Test
    @DisplayName("GIVEN food status not enough in base spaziale WHEN createComunicazioneFood THEN create a Comunication of tipe ComunicationType.SERVIZIO containing in description the string scorte cibo")
    void createComunicazioneFoodNotEnough() {
        //arrange
        Mockito.when(baseSpazialeService.checkFood()).thenReturn(true);
        ComunicationService comunicationService=new ComuncationServiceImpl();
        //acts
        Comunication comunication=comunicationService.createComunicazioneFood(baseSpazialeService);
        //asserts
        //TODO finire
    }
}