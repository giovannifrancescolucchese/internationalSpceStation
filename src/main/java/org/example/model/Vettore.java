package org.example.model;

import lombok.Data;
import org.example.enums.AgenziaSpaziale;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a space vehicle in a space agency's fleet.
 * This class encapsulates the characteristics of a vehicle used for space missions, including its modules,
 * launch and docking dates, crew, capacity, and the space agency it belongs to.
 */
@Data
public class Vettore {
    /**
     * List of modules that the vehicle is composed of. Each module may serve a different purpose, e.g., living quarters, research labs, etc.
     */
    private List<Modulo> moduli;

    /**
     * The date when the vehicle was launched into space.
     */
    private LocalDate lancio;

    /**
     * The date when the vehicle docked with a space station or other spacecraft.
     */
    private LocalDate attracco;

    /**
     * The crew assigned to the vehicle for its mission, including astronauts, scientists, and other personnel.
     */
    private Equipaggio equipaggio;

    /**
     * The number of workstations available in the vehicle, defining its capacity to support a crew.
     */
    private Integer postazioni;

    /**
     * The space agency to which this vehicle belongs. It defines the national or international entity managing the missions of this vehicle.
     */
    private AgenziaSpaziale agenziaSpaziale;
}