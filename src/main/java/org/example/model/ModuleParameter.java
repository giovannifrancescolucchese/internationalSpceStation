package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.ModuloTipo;

import java.time.LocalDateTime;

/**
 * Represents a parameter module that keeps track of specific environmental data.
 * This class stores data about CO2 levels and the timestamp when these levels were recorded.
 * It leverages Lombok annotations for boilerplate code like getters, setters, toString,
 * equals, and hash code method generation, along with a constructor for all arguments.
 */
@Data                   // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor     // Lombok annotation to generate a constructor with one argument for every field in the class
public class ModuleParameter {
    /**
     * The timestamp when the CO2 level was recorded.
     */
    LocalDateTime timestamp;   // Use of LocalDateTime for accurate date-time representation including time-zone.

    /**
     * The recorded CO2 level at the timestamp.
     */
    Integer co2;               // Stores the CO2 level measurement.
}