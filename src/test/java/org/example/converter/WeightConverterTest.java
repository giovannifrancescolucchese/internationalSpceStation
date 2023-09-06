package org.example.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightConverterTest {

    @Test
    @DisplayName("Converte 10 Libbre in 4.53592 Kg")
    void testSetLibbre() {
        //arrange
        WeightConverter converter = new WeightConverter();
        //act
        converter.setLibbre(10);
        //assert
        assertEquals(4.53592, converter.getKili(), 0.0001);
    }

    @Test
    @DisplayName("Converte 10 Kg in 220.462 Libbre.")
    void testSetKili() {
        //arrange
        WeightConverter converter = new WeightConverter();
        //act
        converter.setKili(10.0);
        //assert
        assertEquals(22.0462, converter.getLibbre(), 0.0001);
    }
}