package org.example.converter;

import lombok.Data;
/**
 * classe per la conversione da kg a libbre ... 1 kg = 2,20462 libbre
 */
@Data
public class WeightConverter {
    double kili;
    double libbre;

    void setLibbre(double libbre) {
        this.libbre=libbre;
        this.kili=libbre/2.20462;
    }

    void setKili(double kili) {
        this.kili=kili;
        this.libbre=kili*2.20462;
    }

}
