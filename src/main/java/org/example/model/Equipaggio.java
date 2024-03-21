package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Represents a crew (equipaggio) for a space mission. The class encapsulates the formation of the crew,
 * including the captain and vice captain among the astronauts.
 * <p>
 * This class uses Lombok annotations to minimize boilerplate code such as getters, setters,
 * and a constructor for all arguments. The purpose is to streamline the creation and management of
 * Equipaggio instances, ensuring that all necessary data fields can be easily accessed and modified.
 */
@Data // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor // Lombok annotation to generate a constructor that accepts all class fields
public class Equipaggio {
    // List representing the formation of astronauts in the crew
    List<Astronauta> formazione;
    // The captain of the crew, represented by an Astronauta instance
    Astronauta capitano;
    // The vice captain of the crew, also represented by an Astronauta instance
    Astronauta vice_capitano;
}