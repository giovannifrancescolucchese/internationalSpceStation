package org.example.service;

import org.example.converter.FluidConverter;
import org.example.converter.WeightConverter;
import org.example.enums.ModuloTipo;
import org.example.model.BaseSpaziale;
import org.example.model.Modulo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class BaseSpazialeServiceImpl implements BaseSpazialeService {
    BaseSpaziale baseSpaziale;

    @Override
    public void init(BaseSpaziale baseSpaziale) {
        this.baseSpaziale=baseSpaziale;
    }

    @Override
    public boolean checkWater() {
        List<Modulo> listWaterModules=this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_WATER))
                .collect(Collectors.toList());
        Double water=listWaterModules.stream().map(Modulo::getFluid).collect(Collectors.toList())
                .stream().mapToDouble(FluidConverter::getLitri).sum();
        if (water/this.baseSpaziale.getEquipaggio().getFormazione().size()>1000) return true;
        return false;
    }

    @Override
    public boolean checkFood() {
        List<Modulo> listFoodModules=this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_FOOD))
                .collect(Collectors.toList());
        Double food=listFoodModules.stream().map(Modulo::getWeight).collect(Collectors.toList())
                .stream().mapToDouble(WeightConverter::getKili).sum();
        if (food/this.baseSpaziale.getEquipaggio().getFormazione().size()>800) return true;
        return false;
    }

    @Override
    public boolean checkTrash() {
        List<Modulo> listTrashModules=this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_TRASH)) //FIXED MODULE POINTING TO FOOD ENUM INSTEAD OF TRASH
                .collect(Collectors.toList());
        Double trash=listTrashModules.stream().map(Modulo::getWeight).collect(Collectors.toList())
                .stream().mapToDouble(WeightConverter::getKili).sum();
        if (trash/this.baseSpaziale.getEquipaggio().getFormazione().size()>800) return true;
        return false;
    }

    public boolean checkTrash_bug() {
        List<Modulo> listTrashModules=this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_FOOD)) //FIXED MODULE POINTING TO FOOD ENUM INSTEAD OF TRASH
                .collect(Collectors.toList());
        Double trash=listTrashModules.stream().map(Modulo::getWeight).collect(Collectors.toList())
                .stream().mapToDouble(WeightConverter::getKili).sum();
        if (trash/this.baseSpaziale.getEquipaggio().getFormazione().size()>800) return true;
        return false;
    }
}
