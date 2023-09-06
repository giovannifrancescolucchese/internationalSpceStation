package org.example.converter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class FluidConverterTest {
    
    @ParameterizedTest(name = "GIVEN: {0} gallons WHEN: using this constructor THEN: I will have {1} liters")
    @CsvSource({"1, 3.78541",
            "0.264172, 1",
            Double.MAX_VALUE*0.264172 + " , " + Double.MAX_VALUE, //Expected and Actual are nearly equal, it fails due to approximation
            Double.MIN_VALUE + ", 0",
    })
    void setGalloniParameterizedTest(double firstValue, double result) {
        //ARRANGE
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.FLOOR);
        FluidConverter fluidConverter = new FluidConverter();
        fluidConverter.setGalloni(firstValue);
        //ACT
        double expectedResult = Double.parseDouble(df.format(result));
        double actualResult = Double.parseDouble(df.format(fluidConverter.getLitri()));
        //ASSERT
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "GIVEN: {0} liters WHEN: using this constructor THEN: I will have {1} gallons")
    @CsvSource({"1, 0.264172",
            "3.78541, 0.99",
            Double.MAX_VALUE +","+ Double.MAX_VALUE*0.264172,
            Double.MIN_VALUE + ", 0",
    })
    void setLitersParameterizedTest(double firstValue, double result) {
        //ARRANGE
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.FLOOR);
        FluidConverter fluidConverter = new FluidConverter();
        fluidConverter.setLitri(firstValue);
        //ACT
        result = Double.parseDouble(String.valueOf(result));
        double expectedResult = Double.parseDouble(df.format(result));
        double actualResult = Double.parseDouble(df.format(fluidConverter.getGalloni()));
        //ASSERT
        assertEquals(expectedResult, actualResult);
    }
}