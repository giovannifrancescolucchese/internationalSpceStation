package org.example.model;

import lombok.Data;
import org.example.enums.AgenziaSpaziale;

import java.time.LocalDate;
import java.util.List;

@Data
public class Vettore {
    private List<Modulo> moduli;
    private LocalDate lancio;
    private LocalDate attracco;
    private Equipaggio equipaggio;
    private Integer postazioni;
    private AgenziaSpaziale agenziaSpaziale;

}
