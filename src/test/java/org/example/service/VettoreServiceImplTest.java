package org.example.service;

import org.example.converter.FluidConverter;
import org.example.converter.WeightConverter;
import org.example.enums.AgenziaSpaziale;
import org.example.enums.ModuloTipo;
import org.example.model.Modulo;
import org.example.model.Vettore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VettoreServiceImplTest {

    //possibile bug
    @Test
    void canAddModulo() {
    // Arrange
        VettoreService vettoreService = new VettoreServiceImpl();
        Vettore vettore = new Vettore();
        vettore.setModuli(new ArrayList<>());
        Modulo modulo = new Modulo(1, "modulo test",
                new ArrayList<>(), AgenziaSpaziale.ESA, ModuloTipo.DORMITORIO, new FluidConverter(), new WeightConverter());

    // Act
        boolean canAddModulo = vettoreService.canAddModulo(vettore, modulo);

    // Assert
        Assertions.assertTrue(canAddModulo);
    }
}