package org.example.service;

import org.example.model.Astronauta;
import org.example.model.BaseSpaziale;
import org.example.model.Equipaggio;
import org.example.model.Vettore;

public interface EquipaggioService {
    boolean atLeast1Woman(Equipaggio equipaggio);
    boolean atLeast70percNoSameSpaceAncy(Equipaggio equipaggio, Astronauta astronauta);
    boolean canAddAstronauta(Vettore vettore, Astronauta astronauta, BaseSpaziale baseSpaziale);

}
