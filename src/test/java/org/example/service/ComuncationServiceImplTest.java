package org.example.service;

import org.example.enums.ComunicationType;
import org.example.model.BaseSpaziale;
import org.example.model.Comunication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ComuncationServiceImplTest {

    @Mock
    BaseSpazialeService baseSpazialeService;

    @Test
    @DisplayName("GIVEN food status not enough in base spaziale WHEN createComunicazioneFood THEN create a Comunication of tipe ComunicationType.SERVIZIO with testo equal to ALERT: scorte cibo in esaurimento")
    void createComunicazioneFoodNotEnough() {
        //arrange
        Mockito.when(baseSpazialeService.checkFood()).thenReturn(true);
        ComunicationService comunicationService=new ComuncationServiceImpl();

        //acts
        Comunication comunication=comunicationService.createComunicazioneFood(baseSpazialeService);
        //asserts
        assertEquals(ComunicationType.SERVIZIO, comunication.getComunicationType(), "la tipologia della comunicazione è corretta");
        assertEquals("ALERT: scorte cibo in esaurimento", comunication.getTesto(), "il testo della comunicazione è corretto");
    }


    //l'unico Mock ne test l'ho definito io....
}