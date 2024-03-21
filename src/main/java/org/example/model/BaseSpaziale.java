package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.ModuloTipo;

import java.util.List;

/**
 * Represents a space base, consisting of various modules and a crew.
 * The space base is made up of different types of modules, each serving a different purpose,
 * such as living quarters, laboratories, etc. The class also includes the crew members living
 * and working in the space base.
 */
@Data
@AllArgsConstructor
public class BaseSpaziale {
    List<Modulo> moduli; // List of modules that make up the space base
    Equipaggio equipaggio; // Crew member details

    /**
     * Calculates and returns the total number of beds available in the space base.
     * It sums up the sleeping quarters found in the 'DORMITORIO' type modules.
     *
     * @return Total number of beds in the space base.
     */
    public Integer getPostiLetto() {
        return this.getModuli().stream()

                // Filter 'DORMITORIO' type modules
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.DORMITORIO))

                // Extracts the number of positions (beds in this case) from each filtered module
                .mapToInt(Modulo::getPostazioni)

                // Sums up the number of positions from all the filtered modules
                .sum();
    }
}