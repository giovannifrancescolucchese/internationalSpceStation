package org.example.service;

import org.example.converter.FluidConverter;
import org.example.converter.WeightConverter;
import org.example.enums.AgenziaSpaziale;
import org.example.enums.ModuloTipo;
import org.example.enums.Nazionalita;
import org.example.model.Astronauta;
import org.example.model.BaseSpaziale;
import org.example.model.Equipaggio;
import org.example.model.Modulo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseSpazialeServiceImplTest {

    /* il test falliva, ho reso public il metodo setKili della classe WeithConverter,
      altrimenti non sarebbe stato accessibile al di fuori del package */
    @Test
    void givenBaseWith100TrashWhenheckTrashThenFalse() {
        // Arrange
        Astronauta astronautaCapitano = new Astronauta(
                "Samantha",
                "Cristoforetti",
                LocalDate.of(1977, 4, 26),
                new ArrayList<>(),
                'F',
                Nazionalita.italiana,
                AgenziaSpaziale.ESA,
                new ArrayList<>()
        );

        Astronauta astronautaVice = new Astronauta(
                "John",
                "Black",
                LocalDate.of(1978, 4, 3),
                new ArrayList<>(),
                'M',
                Nazionalita.americana,
                AgenziaSpaziale.NASA,
                new ArrayList<>()
        );

        ArrayList<Astronauta> formazione = new ArrayList<>();
        formazione.add(astronautaCapitano);
        formazione.add(astronautaVice);
        Equipaggio equipaggio = new Equipaggio(formazione, astronautaCapitano, astronautaVice);
        WeightConverter weight = new WeightConverter();
        weight.setKili(100);
        Modulo modulo = new Modulo(0, "trash", new ArrayList<>(), AgenziaSpaziale.NASA, ModuloTipo.STORAGE_TRASH, new FluidConverter(), weight);
        List<Modulo> moduloList = new ArrayList<>();
        moduloList.add(modulo);
        BaseSpaziale baseSpaziale = new BaseSpaziale(moduloList, equipaggio);


        BaseSpazialeService baseSpazialeService = new BaseSpazialeServiceImpl();
        baseSpazialeService.init(baseSpaziale);

        //act
        boolean checkTrash = baseSpazialeService.checkTrash();

        //assert
        assertFalse(checkTrash);
    }
//il test seguente falliva perche' nella classe BaseSpazialeServiceImpl a riga 45 anziche' esserci STORAGE_TRASH c'era STORAGE_FOOD
    @Test
    void givenBaseWith2000TrashWhenCheckTrashThenTrue() {
        // Arrange
        Astronauta astronautaCapitano = new Astronauta(
                "Samantha",
                "Cristoforetti",
                LocalDate.of(1977, 4, 26),
                new ArrayList<>(),
                'F',
                Nazionalita.italiana,
                AgenziaSpaziale.ESA,
                new ArrayList<>()
        );

        Astronauta astronautaVice = new Astronauta(
                "John",
                "Black",
                LocalDate.of(1978, 4, 3),
                new ArrayList<>(),
                'M',
                Nazionalita.americana,
                AgenziaSpaziale.NASA,
                new ArrayList<>()
        );


        ArrayList<Astronauta> formazione = new ArrayList<>();
        formazione.add(astronautaCapitano);
        formazione.add(astronautaVice);
        Equipaggio equipaggio = new Equipaggio(formazione, astronautaCapitano, astronautaVice);
        WeightConverter weight = new WeightConverter();
        weight.setKili(2000);
        Modulo modulo = new Modulo(0, "trash", new ArrayList<>(), AgenziaSpaziale.NASA,
                ModuloTipo.STORAGE_TRASH, new FluidConverter(), weight);
        List<Modulo> moduloList = new ArrayList<>();
        moduloList.add(modulo);
        BaseSpaziale baseSpaziale = new BaseSpaziale(moduloList, equipaggio);


        BaseSpazialeService baseSpazialeService = new BaseSpazialeServiceImpl();
        baseSpazialeService.init(baseSpaziale);

        //act
        boolean checkTrash = baseSpazialeService.checkTrash();

        //assert
        assertTrue(checkTrash);
    }

    @Test
    @DisplayName("GIVEN base with 100 food modulo WHEN check THEN food is not enough")
    void checkFood() {
        // Arrange
        Astronauta astronautaCapitano = new Astronauta(
                "Samantha",
                "Cristoforetti",
                LocalDate.of(1977, 4, 26),
                new ArrayList<>(),
                'F',
                Nazionalita.italiana,
                AgenziaSpaziale.ESA,
                new ArrayList<>()
        );

        Astronauta astronautaVice = new Astronauta(
                "John",
                "Black",
                LocalDate.of(1978, 4, 3),
                new ArrayList<>(),
                'M',
                Nazionalita.americana,
                AgenziaSpaziale.NASA,
                new ArrayList<>()
        );

        ArrayList<Astronauta> formazione = new ArrayList<>();
        formazione.add(astronautaCapitano);
        formazione.add(astronautaVice);
        Equipaggio equipaggio = new Equipaggio(formazione, astronautaCapitano, astronautaVice);
        WeightConverter weight = new WeightConverter();
        weight.setKili(100);
        Modulo modulo = new Modulo(0, "trash", new ArrayList<>(), AgenziaSpaziale.NASA, ModuloTipo.STORAGE_FOOD, new FluidConverter(), weight);
        List<Modulo> moduloList = new ArrayList<>();
        moduloList.add(modulo);
        BaseSpaziale baseSpaziale = new BaseSpaziale(moduloList, equipaggio);


        BaseSpazialeService baseSpazialeService = new BaseSpazialeServiceImpl();
        baseSpazialeService.init(baseSpaziale);

        //act
        boolean checkFood = baseSpazialeService.checkFood();

        //assert
        assertFalse(checkFood);
    }

    //OK
}