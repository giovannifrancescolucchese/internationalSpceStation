package org.example.service;

import org.example.model.Modulo;
import org.example.model.Vettore;

/**
 * Implementation of the {@link VettoreService} interface to provide services related to Vettore (carrier/vehicle) objects.
 * This service class includes methods to manipulate and query Vettore instances.
 */
public class VettoreServiceImpl implements VettoreService {

    /**
     * Checks if a given Modulo (module) can be added to a Vettore (carrier/vehicle) without exceeding a specific threshold.
     * The threshold is defined as the condition where no more than 50% of the modules (Modulo) associated with the Vettore
     * can belong to the same space agency as the Vettore.
     *
     * @param vettore The Vettore to which the Modulo may be added.
     * @param modulo The Modulo that might be added to the Vettore.
     * @return true if adding the Modulo does not cause more than 50% of the modules in the Vettore
     *         to be from the same space agency as the Vettore, otherwise false.
     */
    @Override
    public boolean canAddModulo(Vettore vettore, Modulo modulo) {
        // Count how many modules in the 'vettore' belong to the same space agency as the 'vettore'
        long moduliStessaAgenzia = vettore.getModuli().stream()
                // Use a filter to find modules where the space agency matches the vettore's agency
                .filter(m -> m.getAgenziaSpaziale().equals(vettore.getAgenziaSpaziale()))
                // Count the filtered modules
                .count();

        // Calculate the percentage of modules from the same agency if the new module were added
        double percentualeIfAdd = ((moduliStessaAgenzia + 1) / (double) (vettore.getModuli().size() + 1)) * 100;

        // Return true if the percentage does not exceed 50%
        return (percentualeIfAdd <= 50);
    }

}