package org.example.model;

import org.example.enums.ModuloTipo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BaseSpazialeTest {

    @ParameterizedTest(name= "GIVEN: A Module with {0} dormitories, WHEN: using getPostiLetto, THEN: I should get all of them")
    @CsvSource({"1",
    "10",})
    void getPostiLetto(int modulesToGenerate) {
        //ARRANGE
        Random random = new Random();
        Equipaggio equipaggioMock = Mockito.mock(Equipaggio.class);
        BaseSpaziale baseSpaziale = new BaseSpaziale(equipaggioMock);
        int postazioniTotali = 0;
        for (int x = 1; x <= modulesToGenerate; x++) {
            Modulo modulo = Mockito.mock(Modulo.class);
            baseSpaziale.addModule(modulo);
            Mockito.when(modulo.getModuloTipo()).thenReturn(ModuloTipo.DORMITORIO);
            int postazioni = random.nextInt(10);
            Mockito.when(modulo.getPostazioni()).thenReturn(postazioni);
            postazioniTotali = postazioniTotali+postazioni;
        }
        //ACT
        int result = baseSpaziale.getPostiLetto();
        //ASSERT
        assertEquals(postazioniTotali, result);
    }
}