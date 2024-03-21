package org.example.service;

import org.example.converter.FluidConverter;
import org.example.converter.WeightConverter;
import org.example.enums.ModuloTipo;
import org.example.model.BaseSpaziale;
import org.example.model.Modulo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The BaseSpazialeServiceImpl class implements the BaseSpazialeService interface and provides
 * functionality to manage and check the availability of resources in a space base.
 */
public class BaseSpazialeServiceImpl implements BaseSpazialeService {
    BaseSpaziale baseSpaziale;

    /**
     * Initializes the BaseSpazialeServiceImpl with the given space base.
     *
     * @param baseSpaziale the space base to be managed
     */
    @Override
    public void init(BaseSpaziale baseSpaziale) {
        this.baseSpaziale = baseSpaziale;
    }

    /**
     * Checks the availability of water in the space base.
     *
     * @return true if the total water per crew member is greater than 1000 liters, false otherwise
     */
    @Override
    public boolean checkWaterAvailability() {
        // Filter the modules to get only the water storage modules
        List<Modulo> waterStorageModules = this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_WATER))
                .collect(Collectors.toList());

        // Calculate the total water in litres by converting the fluid of each module and summing them up
        Double totalWaterInLitres = waterStorageModules.stream().map(Modulo::getFluid).collect(Collectors.toList())
                .stream().mapToDouble(FluidConverter::getLitri).sum();

        // Check if the total water per crew member is greater than 1000 litres
        if (totalWaterInLitres / this.baseSpaziale.getEquipaggio().getFormazione().size() > 1000)
            return true;
        return false;
    }

    /**
     * Checks the availability of food in the space base.
     *
     * @return true if the total food per crew member is greater than 800 kilos, false otherwise
     */
    @Override
    public boolean checkFoodAvailability() {
        // Filter the modules to get only the food storage modules
        List<Modulo> foodStorageModules = this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_FOOD))
                .collect(Collectors.toList());

        // Calculate the total food in kilos by converting the weight of each module and summing them up
        Double totalFoodInKilos = foodStorageModules.stream().map(Modulo::getWeight).collect(Collectors.toList())
                .stream().mapToDouble(WeightConverter::getKili).sum();

        // Check if the total food per crew member is greater than 800 kilos
        if (totalFoodInKilos / this.baseSpaziale.getEquipaggio().getFormazione().size() > 800)
            return true;
        return false;
    }

    /**
     * Checks the trash capacity in the space base.
     *
     * @return true if the total trash per crew member is less than 800 kilos, false otherwise
     */
    @Override
    public boolean checkTrashCapacity() {
        // Filter the modules to get only the trash storage modules
        List<Modulo> trashStorageModules = this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_TRASH))
                .collect(Collectors.toList());

        // Calculate the total trash in kilos by converting the weight of each module and summing them up
        Double totalTrashInKilos = trashStorageModules.stream().map(Modulo::getWeight).collect(Collectors.toList())
                .stream().mapToDouble(WeightConverter::getKili).sum();

        // Check if the total trash per crew member is less than 800 kilos
        if (totalTrashInKilos / this.baseSpaziale.getEquipaggio().getFormazione().size() < 800)
            return true;
        return false;
    }
}