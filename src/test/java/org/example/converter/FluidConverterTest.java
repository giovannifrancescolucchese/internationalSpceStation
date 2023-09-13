package org.example.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FluidConverterTest {

    @Test
    @DisplayName("Converte 5 galloni in 18.9 litri.")
    void setGalloni() {
        //arrange
        FluidConverter fluidConverter = new FluidConverter();
        //act
        fluidConverter.setGalloni(5);
        //assert
        assertEquals(18.9271, fluidConverter.getLitri(), 0.0001);
    }

    @Test
    @DisplayName("Converte 5 litri in 1.3 galloni.")
    void setLitri() {
        //arrange
        FluidConverter fluidConverter = new FluidConverter();
        //act
        fluidConverter.setLitri(5);
        //assert
        assertEquals(1.32086, fluidConverter.getGalloni(), 0.0001);
    }
}

//potevi usare parametrized test per vedere un po i BVA