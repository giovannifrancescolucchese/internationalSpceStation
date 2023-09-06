package org.example.converter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FluidConverterTest {

    FluidConverter fc = new FluidConverter();

    @BeforeEach
    void init() {
        FluidConverter fc = new FluidConverter();
    }

    @ParameterizedTest(name = "Given {0} liters Then return {1} gallons ")
    @CsvSource({
            "0.0,  0.0",
            "1.0, 0.264172",
            "100, 26.4172",
            //Double.MAX_VALUE - 1 + ", " + (Double.MAX_VALUE - 1)/0.264172,
            Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY
    })
    void convertLiterToGallon(Double liters, Double expectedResult) {
        //arrange
        fc.setLitri(liters);
        //act
        Double result = fc.getGalloni();
        //assert
        assertEquals(expectedResult, result, () -> String.format("%.2f liters should equals to %.2f gallons", liters, expectedResult));
    }
}