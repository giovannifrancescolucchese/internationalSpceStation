package org.example.converter;

import lombok.Data;

/**
 * classe per la conversione da litri a galloni ... 1 litro = 0,264172 galloni
 */
@Data
public class  FluidConverter {
    double litri;
    double galloni;



    void setGalloni(double galloni) {
        this.galloni=galloni;
        this.litri=galloni/0.264172;
    }

    void setLitri(double litri) {
        this.litri=litri;
        this.galloni=litri*0.264172;
    }


}
