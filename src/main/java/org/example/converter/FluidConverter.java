package org.example.converter;

import lombok.Data;

/**
 * The FluidConverter class provides methods for converting between liters and gallons.
 * It allows setting the value in either liters or gallons and automatically calculates the corresponding value in the other unit.
 * The conversion factor used is 1 liter = 0.264172 gallons.
 */
@Data
public class FluidConverter {
    double litri;
    double galloni;

    /**
     * Sets the value in gallons and calculates the corresponding value in liters.
     *
     * @param galloni the value in gallons to be set
     */
    void setGalloni(double galloni) {
        this.galloni = galloni;
        // Convert gallons to liters using the conversion factor
        this.litri = galloni / 0.264172;
    }

    /**
     * Sets the value in liters and calculates the corresponding value in gallons.
     *
     * @param litri the value in liters to be set
     */
    void setLitri(double litri) {
        this.litri = litri;
        // Convert liters to gallons using the conversion factor
        this.galloni = litri * 0.264172;
    }
}