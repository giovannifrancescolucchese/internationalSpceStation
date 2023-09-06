package org.example.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightConverterTest {
    @Test
    @DisplayName("Converti libre in kili ")
    public void convertiGalloniInLitri() {
        //arrenge
        double kiliAttesi = 0.45359290943563974;
        WeightConverter weightConverter = new WeightConverter();
        weightConverter.setLibbre(1);
        //act
        double risultato= weightConverter.getKili();
        //assert
        assertEquals(kiliAttesi,risultato, String.format("%s libre dovrebbero essere %s kili", weightConverter.libbre, risultato));
    }

    @Test
    @DisplayName("Converti kili in libre ")
    public void convertiKiliInLibre() {
        //arrenge
        double libreAttesi = 2.20462;
        WeightConverter weightConverter = new WeightConverter();
        weightConverter.setKili(1);
        //act
        double risultato= weightConverter.getLibbre();
        //assert
        assertEquals(libreAttesi,risultato, String.format("%s kili dovrebbero essere %s libre", weightConverter.kili, risultato));
    }


}