package org.example.service;

import org.example.converter.FluidConverter;
import org.example.converter.WeightConverter;
import org.example.enums.ModuloTipo;
import org.example.model.BaseSpaziale;
import org.example.model.Modulo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the BaseSpazialeService interface,
 * providing functionality to manage and check resources within a space base.
 */
public class BaseSpazialeServiceImpl2 implements BaseSpazialeService {
    BaseSpaziale baseSpaziale; // Represents the space base this service will manage.

    /**
     * Initialize the service with a specific space base.
     *
     * @param baseSpaziale the BaseSpaziale instance this service will manage.
     */
    @Override
    public void init(BaseSpaziale baseSpaziale) {
        this.baseSpaziale = baseSpaziale;
    }

    /**
     * Checks if the water resources in the space base meet the minimum requirements.
     * Assumes every crew member needs at least 1500 liters of water.
     *
     * @return true if water resources are sufficient, false otherwise.
     */
    @Override
    public boolean checkWaterAvailability() {
        // Filter out water storage modules from all modules in the base.
        List<Modulo> waterStorageModules = this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_WATER))
                .collect(Collectors.toList());

        // Calculate total water available by summing the liters from each water storage module.
        Double totalWaterInLitres = waterStorageModules.stream()
                .map(Modulo::getFluid) // Convert each Modulo to its fluid content
                .collect(Collectors.toList()) // Collect into a list of fluids
                .stream().mapToDouble(FluidConverter::getLitri) // Convert each fluid quantity to liters
                .sum(); // Sum up all liters

        // Return true if the total water per crew member is greater than 1500 liters.
        return totalWaterInLitres / this.baseSpaziale.getEquipaggio().getFormazione().size() > 1500;
    }

    /**
     * Checks if the food resources in the space base meet the minimum requirements.
     * Assumes every crew member needs at least 1600 kilograms of food.
     *
     * @return true if food resources are sufficient, false otherwise.
     */
    @Override
    public boolean checkFoodAvailability() {
        // Filter out food storage modules from all modules in the base.
        List<Modulo> foodStorageModules = this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_FOOD))
                .collect(Collectors.toList());

        // Calculate total food available in kilos by summing weights from each food storage module.
        Double totalFoodInKilos = foodStorageModules.stream()
                .map(Modulo::getWeight) // Convert each Modulo to its weight
                .collect(Collectors.toList()) // Collect into a list of weights
                .stream().mapToDouble(WeightConverter::getKili) // Convert each weight to kilograms
                .sum(); // Sum up all kilograms

        // Return true if the total food per crew member is greater than 1600 kilograms.
        return totalFoodInKilos / this.baseSpaziale.getEquipaggio().getFormazione().size() > 1600;
    }

    /**
     * Checks if the space base's trash storage capacity meets the minimum requirements.
     * Assumes each crew member contributes to over 950 kilograms of trash.
     *
     * @return true if trash storage capacity is sufficient, false otherwise.
     */
    @Override
    public boolean checkTrashCapacity() {
        // Filter out trash storage modules from all modules in the base.
        List<Modulo> trashStorageModules = this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_TRASH))
                .collect(Collectors.toList());

        // Calculate total trash capacity in kilos by summing weights from each trash storage module.
        Double totalTrashInKilos = trashStorageModules.stream()
                .map(Modulo::getWeight) // Convert each Modulo to its weight
                .collect(Collectors.toList()) // Collect into a list of weights
                .stream().mapToDouble(WeightConverter::getKili) // Convert each weight to kilograms
                .sum(); // Sum up all kilograms

        // Return true if the trash per crew member is greater than 950 kilograms.
        return totalTrashInKilos / this.baseSpaziale.getEquipaggio().getFormazione().size() > 950;
    }
}
