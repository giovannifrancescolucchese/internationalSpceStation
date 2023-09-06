package org.example.model;

import org.example.converter.FluidConverter;
import org.example.converter.WeightConverter;
import org.example.enums.AgenziaSpaziale;
import org.example.enums.ModuloTipo;
import org.example.enums.Nazionalita;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseSpazialeTest {

    @Test
    @DisplayName("GIVEN empty BaseSpaziale THEN zero posti letto.")
    public void getPostiLetto() {
        // Arrange
        Astronauta astronautaCapitano = new Astronauta("Samantha", "Cristoforetti", LocalDate.of(1977, 4, 26), new ArrayList<>(), 'F', Nazionalita.italiana, AgenziaSpaziale.ESA, new ArrayList<>());

        Astronauta astronautaVice = new Astronauta("John", "Black", LocalDate.of(1978, 4, 3), new ArrayList<>(), 'M', Nazionalita.americana, AgenziaSpaziale.NASA, new ArrayList<>());


        Equipaggio equipaggio = new Equipaggio(new ArrayList<>(), astronautaCapitano, astronautaVice);
        BaseSpaziale baseSpaziale = new BaseSpaziale(new ArrayList<>(), equipaggio);

        // Act
        Integer postiLetto = baseSpaziale.getPostiLetto();

        // Assert
        assertEquals(0, postiLetto);
    }

    @Test
    @DisplayName("GIVEN BaseSpaziale WHEN modulo dormitorio 5 postazioni THEN 5 posti letto.")
    public void getPostiLetto2() {
        // Arrange
        Astronauta astronautaCapitano = new Astronauta("Samantha", "Cristoforetti", LocalDate.of(1977, 4, 26), new ArrayList<>(), 'F', Nazionalita.italiana, AgenziaSpaziale.ESA, new ArrayList<>());


        Astronauta astronautaVice = new Astronauta("John", "Black", LocalDate.of(1978, 4, 3), new ArrayList<>(), 'M', Nazionalita.americana, AgenziaSpaziale.NASA, new ArrayList<>());


        Equipaggio equipaggio = new Equipaggio(new ArrayList<>(), astronautaCapitano, astronautaVice);
        Modulo modulo = new Modulo(5, "posti letto", new ArrayList<>(), AgenziaSpaziale.NASA, ModuloTipo.DORMITORIO, new FluidConverter(), new WeightConverter());
        List<Modulo> moduloList = new ArrayList<>();
        moduloList.add(modulo);
        BaseSpaziale baseSpaziale = new BaseSpaziale(moduloList, equipaggio);


        // Act
        Integer postiLetto = baseSpaziale.getPostiLetto();

        // Assert
        assertEquals(5, postiLetto);
    }
}
