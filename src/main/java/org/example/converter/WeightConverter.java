package org.example.converter;

import lombok.Data;

/**
 * The WeightConverter class provides functionality to convert weight between kilograms and pounds.
 * It allows setting the weight in either kilograms or pounds and automatically calculates the corresponding value in the other unit.
 * The conversion factor used is 1 kg = 2.20462 pounds.
 */
@Data
public class WeightConverter {
    private double kili;
    private double libbre;

    /**
     * Sets the weight in pounds and calculates the corresponding value in kilograms.
     *
     * @param libbre the weight in pounds
     */
    void setLibbre(double libbre) {
        this.libbre = libbre;
        // Convert pounds to kilograms using the conversion factor
        this.kili = libbre / 2.20462;
    }

    /**
     * Sets the weight in kilograms and calculates the corresponding value in pounds.
     *
     * @param kili the weight in kilograms
     */
    void setKili(double kili) {
        this.kili = kili;
        // Convert kilograms to pounds using the conversion factor
        this.libbre = kili * 2.20462;
    }
}