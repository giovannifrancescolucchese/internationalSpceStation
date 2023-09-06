package org.example.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FluidConverterTest {

    FluidConverter fluidConverter = new FluidConverter();


    @BeforeEach
    void init() {
        fluidConverter = new FluidConverter();
    }

    @ParameterizedTest(name = "Given volume of fluid in {0} litres, then convert in to {1} gallons ")
    @CsvSource({
            "0.0, 0.0",
            "3.785412534257983, 1.0"


    })
    void convertLitresToGallons(double litres, double expectedResult) {
        //Arrange
        fluidConverter.setLitri(litres);

        //Act
        Double result = fluidConverter.getGalloni();

        //Assert
        assertEquals(expectedResult, result, () -> String.format("%1$,.2f litres should equals to %2$,.2f gallons", litres, expectedResult));
    }

    @ParameterizedTest(name = "Given volume of fluid in {0} gallons, then convert in to {1} litres ")
    @CsvSource({
            "0.0, 0.0",
            "1.0, 3.785412534257983",
            Double.MAX_VALUE - 1 + ", " + Double.POSITIVE_INFINITY,
            Double.MAX_VALUE + ", " + Double.POSITIVE_INFINITY

    })
    void convertGallonsToLitres(double gallons, double expectedResult) {
        //Arrange
        fluidConverter.setGalloni(gallons);

        //Act
        Double result = fluidConverter.getLitri();

        //Assert
        assertEquals(expectedResult, result, () -> String.format("%1$,.2f gallons should equals to %2$,.2f litres", gallons, expectedResult));
    }

}