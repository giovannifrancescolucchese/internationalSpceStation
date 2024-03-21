package org.example.service;

import org.example.model.Astronauta;
import org.example.model.BaseSpaziale;
import org.example.model.Equipaggio;
import org.example.model.Vettore;

/**
 * The {@code EquipaggioService} interface defines methods to check various conditions for
 * astronauts and their assignments to missions. It includes methods to evaluate conditions
 * such as gender diversity, affiliation diversity, and payload capacity checks before
 * astronauts are added to missions.
 */
public interface EquipaggioService {

    /**
     * Checks if there is at least one woman in the crew.
     *
     * @param equipaggio The crew ({@link Equipaggio}) being evaluated.
     * @return {@code true} if there is at least one woman in the crew, {@code false} otherwise.
     */
    boolean atLeast1Woman(Equipaggio equipaggio);

    /**
     * Evaluates if at least 70 percent of the crew, including the provided astronaut, does not belong
     * to the same space agency.
     *
     * @param equipaggio The crew ({@link Equipaggio}) being evaluated, without the provided astronaut.
     * @param astronauta The astronaut ({@link Astronauta}) being considered for addition to the crew.
     * @return {@code true} if adding the astronaut keeps or achieves the condition of no more than 30 percent
     *         of the crew (including the astronaut being added) being from the same space agency, {@code false} otherwise.
     */
    boolean atLeast70percNoSameSpaceAncy(Equipaggio equipaggio, Astronauta astronauta);

    /**
     * Determines if an astronaut can be added to a spacecraft going to a specific space base, considering
     * the spacecraft's capacity and the base's requirements.
     *
     * @param vettore The spacecraft ({@link Vettore}) being considered for this mission.
     * @param astronauta The astronaut ({@link Astronauta}) being considered for addition to the spacecraft.
     * @param baseSpaziale The destination space base ({@link BaseSpaziale}) for this mission.
     * @return {@code true} if the astronaut can be added without exceeding the capacity of the spacecraft and
     *         meeting the base's requirements, {@code false} otherwise.
     */
    boolean canAddAstronauta(Vettore vettore, Astronauta astronauta, BaseSpaziale baseSpaziale);

}