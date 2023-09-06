package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.AgenziaSpaziale;
import org.example.enums.CompitoAstronauta;
import org.example.enums.Nazionalita;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Astronauta {
    private String nome;
    private String cognome;
    private LocalDate birthDate;
    private List<CompitoAstronauta> compito;
    private Character sesso;
    private Nazionalita nazionalita;
    private AgenziaSpaziale agenziaSpaziale;
    List<LifeParameter> lifeParameters;

}
