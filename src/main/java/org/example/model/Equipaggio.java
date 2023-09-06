package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Equipaggio {
    List<Astronauta> formazione;
    Astronauta capitano;
    Astronauta vice_capitano;

}
