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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VettoreServiceImplTest {

    @Mock
    FluidConverter fluidConverter;
    WeightConverter weightConverter;
    List<ModuleParameter> moduleParameterList;

    @Spy
    Vettore vettoreMock=new Vettore();

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


    //qua mi sono incartato!!! :)


    //I test di per se non hanno bisogno di argomenti
    @Test
    @DisplayName("GIVEN una agenzia che ha gia il 60% di moduli nel VETTORE WHEN canAddModulo THEN false")
    void canAddModulo() {
        //arrange
        VettoreServiceImpl vettoreService = new VettoreServiceImpl();
        Modulo modulo1 = new Modulo(0, "", moduleParameterList, AgenziaSpaziale.NASA, ModuloTipo.BIOLOGIA, fluidConverter, weightConverter);
        Modulo modulo2 = new Modulo(0, "", moduleParameterList, AgenziaSpaziale.ESA, ModuloTipo.BIOLOGIA, fluidConverter, weightConverter);
        List<Modulo> moduleList=new ArrayList();
        moduleList.add(modulo1);
        moduleList.add(modulo1);
        moduleList.add(modulo1);
        moduleList.add(modulo1);
        moduleList.add(modulo1);
        moduleList.add(modulo1);
        moduleList.add(modulo2);
        moduleList.add(modulo2);
        moduleList.add(modulo2);
        moduleList.add(modulo2);
        vettoreMock.setModuli(moduleList);
        vettoreMock.setAgenziaSpaziale(AgenziaSpaziale.NASA);
        //act
        boolean result = vettoreService.canAddModuloCorrect(vettoreMock, modulo1);
        //C'ERA BUG in canAddModulo
        //assert
        assertFalse(result);
    }

}

