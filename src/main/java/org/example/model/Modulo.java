package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.converter.FluidConverter;
import org.example.converter.WeightConverter;
import org.example.enums.AgenziaSpaziale;
import org.example.enums.ModuloTipo;

import java.util.List;

@Data
@AllArgsConstructor
public class Modulo {
    private Integer postazioni;
    private String descrizione;
    private List<ModuleParameter> moduleParameters;
    private AgenziaSpaziale agenziaSpaziale;
    private ModuloTipo moduloTipo;
    private FluidConverter fluid;
    private WeightConverter weight;


}
