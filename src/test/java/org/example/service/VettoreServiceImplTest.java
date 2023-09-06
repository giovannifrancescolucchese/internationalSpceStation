package org.example.service;

import org.example.converter.FluidConverter;
import org.example.converter.WeightConverter;
import org.example.enums.AgenziaSpaziale;
import org.example.enums.ModuloTipo;
import org.example.model.ModuleParameter;
import org.example.model.Modulo;
import org.example.model.Vettore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VettoreServiceImplTest {

    @Mock
    FluidConverter fluidConverter;
    WeightConverter weightConverter;
    List<ModuleParameter> moduleParameterList;

    @Test
    @DisplayName("GIVEN una agenzia che ha gia il 60% di moduli nella ISS WHEN canAddModulo THEN false")
    void canAddModulo(Vettore vettore, Modulo modulo) {
        //arrange
        VettoreServiceImpl vettoreService = new VettoreServiceImpl();

        Modulo modulo1 = new Modulo(0, "", moduleParameterList, AgenziaSpaziale.NASA, ModuloTipo.BIOLOGIA, fluidConverter, weightConverter);
        //act
        boolean result = vettoreService.canAddModulo(vettore, modulo1);
        //assert
        assertFalse(result);
    }
}


//qua mi sono incartato!!! :)