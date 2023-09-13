package org.example.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class WeightConverterTest {

    WeightConverter weightConverter = new WeightConverter();

    @BeforeEach
    void init() {
        weightConverter = new WeightConverter();
    }

    @ParameterizedTest(name = "Given weight in {0} killograms convert it in {1} libbre")
    @CsvSource({
            "0.0, 0.0",
            "1.0,  2.20462"
    })
    void convertKillogramsToLibbres(double killograms, double expectedResult) {

        //Arrange
        weightConverter.setKili(killograms);

        //Act
        Double result = weightConverter.getLibbre();

        //Assert
        assertEquals(expectedResult, result, () -> String.format("%1$,.2f killograms should equals to %2$,.2f libre's", killograms, expectedResult));
    }


    @ParameterizedTest(name = "Given weight in {0} libbre convert it in {1}  killograms")
    @CsvSource({
            "0.0, 0.0",
            "1.0,  0.45359290943563974"
    })
    void convertLibbresToKillograms(double libbre, double expectedResult) {

        //Arrange
        weightConverter.setLibbre(libbre);

        //Act
        Double result = weightConverter.getKili();

        //Assert
        assertEquals(expectedResult, result, () -> String.format("%1$,.2f libbre should equals to %2$,.2f killograms", libbre, expectedResult));
    }


}
//OK