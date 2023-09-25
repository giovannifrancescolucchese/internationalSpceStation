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
        Mockito.when(baseSpazialeService.checkFood()).thenReturn(false);
        ComunicationService comunicationService=new ComuncationServiceImpl();

        //acts
        Comunication comunication=comunicationService.createComunicazioneFood(baseSpazialeService);
        //asserts
        assertEquals(ComunicationType.SERVIZIO, comunication.getComunicationType(), "la tipologia della comunicazione è corretta");
        assertEquals("ALERT: scorte cibo in esaurimento", comunication.getTesto(), "il testo della comunicazione è corretto");

    }
    @Test
    @DisplayName("GIVEN water status not enough in base spaziale WHEN createComunicazioneWater THEN create a Comunication of tipe ComunicationType.SERVIZIO with testo equal to ALERT: scorta acqua in esaurimento")
    void createComunicazioneWaterNotEnough() {
        //arrange

        Mockito.when(baseSpazialeService.checkWater()).thenReturn(false);
        ComunicationService comunicationService=new ComuncationServiceImpl();

        //acts
        Comunication comunication=comunicationService.createComunicazioneWater(baseSpazialeService);
        //asserts
        assertFalse(baseSpazialeService.checkWater());
        // C'è un errore!
        //Perchè se checkWater è False viene generata l'altra comunicazione! Al contrario di checkfood
        //Errore corretto
        // Ora i metodi sono coerenti con checkFood
        assertEquals(ComunicationType.SERVIZIO, comunication.getComunicationType(), "la tipologia della comunicazione è corretta");
        assertEquals("ALERT: scorta acqua in esaurimento", comunication.getTesto(), "il testo della comunicazione è corretto");

    }
    @Test
    @DisplayName("GIVEN trash status  enough in base spaziale WHEN createComunicazioneWater THEN create a Comunication of tipe ComunicationType.SERVIZIO with testo equal to ")
    void createComunicazioneTrashEnough() {
        // Errore corretto
        // C'era scritto checkFood invece che checkTrash
        // Ora i metodi sono coerenti con checkFood con il not
        //arrange

        Mockito.when(baseSpazialeService.checkTrash()).thenReturn(false);
        ComunicationService comunicationService=new ComuncationServiceImpl();

        //acts
        Comunication comunication=comunicationService.createComunicazioneTrash(baseSpazialeService);
        //asserts
        assertFalse(baseSpazialeService.checkTrash());

        assertEquals(ComunicationType.SERVIZIO, comunication.getComunicationType(), "la tipologia della comunicazione è corretta");
        assertEquals("ALERT: espellere la spazzatura", comunication.getTesto(), "il testo della comunicazione è corretto");

    }
}