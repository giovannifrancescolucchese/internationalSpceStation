package org.example.converter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class WeightConverterTest {

    @ParameterizedTest(name = "GIVEN: {0} lbs WHEN: using this constructor THEN: I will have {1} kili")
    @CsvSource({"1, 0.453592",
            "2.20462, 1",
            Double.MAX_VALUE +","+ Double.MAX_VALUE / 2.20462,
            Double.MIN_VALUE + ", 0",
    })
    void setLbsParameterizedTest(double firstValue, double result) {
        //ARRANGE
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.FLOOR);
        WeightConverter weightConverter = new WeightConverter();
        weightConverter.setLibbre(firstValue);
        //ACT
        result = Double.parseDouble(String.valueOf(result));
        double expectedResult = Double.parseDouble(df.format(result));
        double actualResult = Double.parseDouble(df.format(weightConverter.getKili()));
        //ASSERT
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name = "GIVEN: {0} kili WHEN: using this constructor THEN: I will have {1} lbs")
    @CsvSource({"1, 2.20462",
            "0.453592, 0.99",
            Double.MAX_VALUE/2.20462 +","+ Double.MAX_VALUE,
            Double.MIN_VALUE + ", 0",
    })
    void setKiliParameterizedTest(double firstValue, double result) {
        //ARRANGE
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.FLOOR);
        WeightConverter weightConverter = new WeightConverter();
        weightConverter.setKili(firstValue);
        //ACT
        result = Double.parseDouble(String.valueOf(result));
        double expectedResult = Double.parseDouble(df.format(result));
        double actualResult = Double.parseDouble(df.format(weightConverter.getLibbre()));
        //ASSERT
        assertEquals(expectedResult, actualResult);
    }
}