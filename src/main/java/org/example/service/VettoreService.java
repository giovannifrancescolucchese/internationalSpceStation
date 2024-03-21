package org.example.service;

import org.example.model.Astronauta;
import org.example.model.Modulo;
import org.example.model.Vettore;

/**
 * The {@code VettoreService} interface provides the contract for services managing the Vectore (Spacecraft)
 * operations, particularly focusing on handling the modules within the spacecraft.
 * This interface is central to ensure the modifications on the spacecraft comply
 * with its capacity and safety regulations.
 */
public interface VettoreService {
    /**
     * Determines if a given module can be safely added to a spacecraft (Vettore).
     * This might involve checking the current weight, size, capacity,
     * and compatibility of the module with the spacecraft's design.
     * Preconditions, such as the spacecraft and module not being null and
     * the spacecraft having enough capacity, should be considered.
     *
     * @param vettore The spacecraft to which the module might be added. Should not be {@code null}.
     * @param modulo The module that is considered to be added to the spacecraft. Should not be {@code null}.
     * @return {@code true} if the module can be added to the spacecraft under the current conditions,
     *         {@code false} otherwise.
     */
    boolean canAddModulo(Vettore vettore, Modulo modulo);
}