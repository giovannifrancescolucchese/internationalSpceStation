package org.example.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class WeightConverterTest {
    WeightConverter wc = new WeightConverter();

    @BeforeEach
    void init() {
        WeightConverter wc = new WeightConverter();
    }

    @ParameterizedTest(name = "Given {0} kili Then return {1} libbre ")
    @CsvSource({
            "0.0,  0.0",
            "1.0, 2.20462",
            "100, 220.462",
            Double.MAX_VALUE - 1 + ", " + (Double.MAX_VALUE - 1) * 2.20462,
            Double.POSITIVE_INFINITY + ", " + Double.POSITIVE_INFINITY
    })
    void convertKiliToLibbre(Double kili, Double expectedResult) {
        //arrange
        wc.setKili(kili);
        //act
        Double result = wc.getLibbre();
        //assert
        assertEquals(expectedResult, result, () -> String.format("%.2f kili should equals to %.2f libbre", kili, expectedResult));
    }
}