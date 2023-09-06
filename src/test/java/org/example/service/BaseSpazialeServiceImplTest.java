package org.example.service;

import org.example.converter.FluidConverter;
import org.example.converter.WeightConverter;
import org.example.enums.AgenziaSpaziale;
import org.example.enums.ModuloTipo;
import org.example.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseSpazialeServiceImplTest {

    List<Modulo> moduli;
    BaseSpaziale baseSpaziale;

    void reArrangeLifeModule(int supply, int astronautsNumber, ModuloTipo moduloTipo) {
        moduli = new ArrayList<>();
        List<ModuleParameter> moduleParameter = Mockito.mock(List.class);
        FluidConverter fluidConverter = new FluidConverter();
        fluidConverter.setLitri(supply);
        WeightConverter weightConverter = new WeightConverter();
        weightConverter.setKili(supply);
        Modulo module = new Modulo(100, "", moduleParameter, AgenziaSpaziale.NASA, moduloTipo, fluidConverter, weightConverter);
        List<Modulo> moduli = new ArrayList<>();
        moduli.add(module);
        List<Astronauta> fakeAstronautsList = new ArrayList<>();
        for (int x = 1; x <= astronautsNumber; x++) {
            fakeAstronautsList.add(Mockito.mock(Astronauta.class));
        }
        Astronauta astronauta = Mockito.mock(Astronauta.class);
        Equipaggio equipaggio = new Equipaggio(fakeAstronautsList, astronauta, astronauta);
        this.baseSpaziale = new BaseSpaziale(moduli, equipaggio);
    }

    @ParameterizedTest(name = "GIVEN: A space station whose water supply is {0} liters with {1} astronauts WHEN: checkWater, THEN {2}")
    @CsvSource({"1001, 1, true",
            "799, 1, false"})
    void checkWater(int supply, int astronauts, boolean expectedResult) {
        //ARRANGE
        reArrangeLifeModule(supply, astronauts, ModuloTipo.STORAGE_WATER);
        BaseSpazialeServiceImpl baseSpazialeService = new BaseSpazialeServiceImpl(baseSpaziale);
        //ACT
        boolean result = baseSpazialeService.checkWater();
        //ASSERT
        assertEquals(result, expectedResult);
    }

    @ParameterizedTest(name = "GIVEN: A space station whose food supply weight is {0} kg  with {1} astronauts, WHEN: checkFood, THEN {2}")
    @CsvSource({"801, 1, true",
    "799, 1, false"})
    void checkFood(int supply, int astronauts, boolean expectedResult) {
        //ARRANGE
        reArrangeLifeModule(supply, astronauts, ModuloTipo.STORAGE_FOOD);
        BaseSpazialeServiceImpl baseSpazialeService = new BaseSpazialeServiceImpl(baseSpaziale);
        //ACT
        boolean result = baseSpazialeService.checkFood();
        //ASSERT
        assertEquals(result, expectedResult);
    }

    @ParameterizedTest(name = "GIVEN: A space station whose trash storage is {0} with {1} astronauts, WHEN: checkTrash, THEN {2}")
    @CsvSource({"801, 1, true",
            "799, 1, false"})
    void checkTrash(int supply, int astronauts, boolean expectedResult) {
        //ARRANGE
        reArrangeLifeModule(supply, astronauts, ModuloTipo.STORAGE_TRASH);
        BaseSpazialeServiceImpl baseSpazialeService = new BaseSpazialeServiceImpl(baseSpaziale);
        //ACT
        boolean result = baseSpazialeService.checkTrash();
        //ASSERT
        assertEquals(result, expectedResult);
    }

    @ParameterizedTest(name = "GIVEN: A space station whose trash storage is {0} with {1} astronauts, WHEN: checkTrash, THEN {2}")
    @CsvSource({"801, 1, true",
            "799, 1, false"})
    void checkTrashBug(int supply, int astronauts, boolean expectedResult) {
        //ARRANGE
        reArrangeLifeModule(supply, astronauts, ModuloTipo.STORAGE_TRASH);
        BaseSpazialeServiceImpl baseSpazialeService = new BaseSpazialeServiceImpl(baseSpaziale);
        //ACT
        boolean result = baseSpazialeService.checkTrash_bug();
        //ASSERT
        assertEquals(result, expectedResult);
    }
}