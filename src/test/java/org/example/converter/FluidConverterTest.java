package org.example.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FluidConverterTest {

    @Test
    @DisplayName("Converti galloni in litri ")
    public void convertiGalloniInLitri() {
        //arrenge
        double litriAttesi = 3.785412534257983;
        FluidConverter fluidConverter = new FluidConverter();
        fluidConverter.setGalloni(1);
        //act
        double risultato= fluidConverter.getLitri();
        //assert
        assertEquals(litriAttesi,risultato, String.format("%s galloni dovrebbero essere %s litri", fluidConverter.galloni, risultato));
    }

    @Test
    @DisplayName("Converti litri in galloni")
    void convertiLitriInGalloni() {
        //arrenge
        FluidConverter fluidConverter = new FluidConverter();
        double galloniAtesi=0.264172;
        fluidConverter.setLitri(1);
        //act
        double risultato= fluidConverter.getGalloni();
        //assert
        assertEquals(galloniAtesi,risultato, String.format("%s litri dovrebbero essere %s galloni", fluidConverter.litri, risultato));
    }
}