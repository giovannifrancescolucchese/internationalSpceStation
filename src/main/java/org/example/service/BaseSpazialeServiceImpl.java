package org.example.service;

import org.example.converter.FluidConverter;
import org.example.converter.WeightConverter;
import org.example.enums.ModuloTipo;
import org.example.model.BaseSpaziale;
import org.example.model.Modulo;

import java.util.List;
import java.util.stream.Collectors;

public class BaseSpazialeServiceImpl implements BaseSpazialeService {
    BaseSpaziale baseSpaziale;

    @Override
    public void init(BaseSpaziale baseSpaziale) {
        this.baseSpaziale = baseSpaziale;
    }

    @Override
    public boolean checkWaterAvailability() {
        List<Modulo> waterStorageModules = this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_WATER))
                .collect(Collectors.toList());

        Double totalWaterInLitres = waterStorageModules.stream().map(Modulo::getFluid).collect(Collectors.toList())
                .stream().mapToDouble(FluidConverter::getLitri).sum();

        if (totalWaterInLitres / this.baseSpaziale.getEquipaggio().getFormazione().size() > 1000)
            return true;
        return false;
    }

    @Override
    public boolean checkFoodAvailability() {
        List<Modulo> foodStorageModules = this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_FOOD))
                .collect(Collectors.toList());

        Double totalFoodInKilos = foodStorageModules.stream().map(Modulo::getWeight).collect(Collectors.toList())
                .stream().mapToDouble(WeightConverter::getKili).sum();

        if (totalFoodInKilos / this.baseSpaziale.getEquipaggio().getFormazione().size() > 800)
            return true;
        return false;
    }

    @Override
    public boolean checkTrashCapacity() {
        List<Modulo> trashStorageModules = this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_TRASH))
                .collect(Collectors.toList());

        Double totalTrashInKilos = trashStorageModules.stream().map(Modulo::getWeight).collect(Collectors.toList())
                .stream().mapToDouble(WeightConverter::getKili).sum();

        if (totalTrashInKilos / this.baseSpaziale.getEquipaggio().getFormazione().size() < 800)
            return true;
        return false;
    }
}