package org.example.service;

import org.example.model.Modulo;
import org.example.model.Vettore;

public class VettoreServiceImpl implements VettoreService {
    @Override
    public boolean canAddModulo(Vettore vettore, Modulo modulo) {
        long moduliStessaAgenzia = vettore.getModuli().stream()
                .filter(m -> m.getAgenziaSpaziale().equals(vettore.getAgenziaSpaziale())).count();
        double percentualeIfAdd = ((moduliStessaAgenzia + 1) / (vettore.getModuli().size() + 1)) * 100;
        return (percentualeIfAdd <= 50);
    }


}
