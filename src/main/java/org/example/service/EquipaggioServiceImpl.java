package org.example.service;

import org.example.enums.ModuloTipo;
import org.example.model.*;

/**
 * Service implementation to manage operations related to {@link Equipaggio}.
 * This includes checking for specific conditions to add an astronaut to a crew.
 */
public class EquipaggioServiceImpl implements EquipaggioService {

    /**
     * Checks if there is at least one woman in the crew.
     *
     * @param equipaggio the crew to check.
     * @return true if there is at least one woman, false otherwise.
     */
    @Override
    public boolean atLeast1Woman(Equipaggio equipaggio) {
        // Parallel stream for potentially better performance on large data sets
        return equipaggio.getFormazione().stream().parallel()
                .filter(astronauta -> astronauta.getSesso() == 'F') // Filter astronauta by gender 'F'
                .findAny().isPresent(); // Return true if any match is found
    }

    /**
     * Checks if adding an astronaut results in no more than 70% of the crew from the same space agency.
     *
     * @param equipaggio the crew to check.
     * @param astronauta the astronaut to potentially add to the crew.
     * @return true if the condition is satisfied, false otherwise.
     */
    @Override
    public boolean atLeast70percNoSameSpaceAncy(Equipaggio equipaggio, Astronauta astronauta) {
        // Count members of the same space agency
        long astronautiStessaAgenzia = equipaggio.getFormazione().stream()
                .filter(a -> a.getAgenziaSpaziale().equals(astronauta.getAgenziaSpaziale())).count();

        // Calculate percentage if the astronaut is added
        double percentualeIfAdd = ((astronautiStessaAgenzia + 1) / (double)(equipaggio.getFormazione().size() + 1)) * 100;

        return (percentualeIfAdd <= 70);
    }

    /**
     * Determines if an astronaut can be added to a given crew based on several conditions.
     * These include available positions on the vector, sufficient sleeping quarters, and
     * ensuring gender diversity and space agency representation within the crew.
     *
     * @param vettore the vehicle vector.
     * @param astronauta the astronaut to add.
     * @param baseSpaziale the space base.
     * @return true if the astronaut can be added, false otherwise.
     */
    @Override
    public boolean canAddAstronauta(Vettore vettore, Astronauta astronauta, BaseSpaziale baseSpaziale) {
        // Check if there are available positions on the vettore (vehicle)
        if (vettore.getPostazioni() > vettore.getEquipaggio().getFormazione().size()) {
            // Calculate free sleeping spots at the base and within the vehicle modules
            Integer postiLettoLiberiBase = baseSpaziale.getPostiLetto() - baseSpaziale.getEquipaggio().getFormazione().size();

            // Sum of positions in DORMITORY modules
            Integer postiLettoModuliVettore = vettore.getModuli().stream()
                    .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.DORMITORIO))
                    .mapToInt(Modulo::getPostazioni).sum();

            // Check if there are enough sleeping spots for the crew including the new astronaut
            if ((postiLettoLiberiBase + postiLettoModuliVettore) > vettore.getEquipaggio().getFormazione().size()) {
                // Check if the astronaut being added is female or if there's already at least one woman in the crew
                if (astronauta.getSesso().equals('F') || this.atLeast1Woman(vettore.getEquipaggio()))
                {
                    // Finally, check if adding the astronaut adheres to the space agency representation rule
                    return this.atLeast70percNoSameSpaceAncy(vettore.getEquipaggio(), astronauta);
                }
            }
        }
        return false;
    }
}