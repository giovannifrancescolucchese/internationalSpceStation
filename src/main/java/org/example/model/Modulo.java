package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.converter.FluidConverter;
import org.example.converter.WeightConverter;
import org.example.enums.AgenziaSpaziale;
import org.example.enums.ModuloTipo;

import java.util.List;

/**
 * Represents a module, potentially of a spacecraft or research facility, managed by a space agency.
 * This class holds the configuration and operational parameters of the module, including its capacity,
 * physical description, operational parameters, owning space agency, type of module, and converters
 * for handling fluid and weight measurements according to specific needs.
 */
@Data // Lombok annotation to generate getters, setters, equals, hashCode, and toString methods.
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields as parameters.
public class Modulo {
    /**
     * Number of workstation positions available within the module.
     */
    private Integer postazioni;

    /**
     * A textual description of the module's purpose and characteristics.
     */
    private String descrizione;

    /**
     * Operational parameters for the module. Might include temperature settings, power usage, etc.
     */
    private List<ModuleParameter> moduleParameters;

    /**
     * The space agency responsible for the module. Enum value representing agencies like NASA, ESA, etc.
     */
    private AgenziaSpaziale agenziaSpaziale;

    /**
     * The type of module, e.g., habitation, laboratory, etc. Enum value representing the different potential types.
     */
    private ModuloTipo moduloTipo;

    /**
     * Converter for fluid measurements, allowing conversion between different units of measurement.
     */
    private FluidConverter fluid;

    /**
     * Converter for weight measurements, facilitating conversion between various units of mass.
     */
    private WeightConverter weight;

    // Note: Actual method implementations would be here, possibly utilizing the fields above.
    // However, since this class uses Lombok to generate standard methods, there's no explicit code to document.
}