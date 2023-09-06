package org.example.service;

import org.example.enums.ModuloTipo;
import org.example.model.*;

public class EquipaggioServiceImpl implements EquipaggioService {
    @Override
    public boolean atLeast1Woman(Equipaggio equipaggio) {
        return equipaggio.getFormazione().stream().parallel()
                .filter(astronauta -> astronauta.getSesso() == 'F').findAny().isPresent();
    }

    @Override
    public boolean atLeast70percNoSameSpaceAncy(Equipaggio equipaggio, Astronauta astronauta) {
        long astronautiStessaAgenzia=equipaggio.getFormazione().stream()
                .filter(a -> a.getAgenziaSpaziale().equals(astronauta.getAgenziaSpaziale())).count();
        double percentualeIfAdd=((astronautiStessaAgenzia+1)/(equipaggio.getFormazione().size()+1d))*100d;
        return (percentualeIfAdd<=70d);
    }

    @Override
    public boolean canAddAstronauta(Vettore vettore, Astronauta astronauta, BaseSpaziale baseSpaziale) {
        //se ci sono posti sul vettore
        if (vettore.getPostazioni() > vettore.getEquipaggio().getFormazione().size()) {
            //se ci sono ancora posti letto
            Integer postiLettoLiberiBase = baseSpaziale.getPostiLetto() - baseSpaziale.getEquipaggio().getFormazione().size();
            Integer postiLettoModuliVettore = vettore.getModuli().stream()
                    .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.DORMITORIO))
                    .mapToInt(Modulo::getPostazioni).sum();
            if ((postiLettoLiberiBase + postiLettoModuliVettore) > vettore.getEquipaggio().getFormazione().size()) {
                //se sto aggiungendo una donna o c'è già una donna nell'equipaggio
                if (astronauta.getSesso().equals('F') || this.atLeast1Woman(vettore.getEquipaggio()))
                {
                    if (this.atLeast70percNoSameSpaceAncy(vettore.getEquipaggio(), astronauta)) return true;
                }
            }
        }
        return false;
    }

    }
