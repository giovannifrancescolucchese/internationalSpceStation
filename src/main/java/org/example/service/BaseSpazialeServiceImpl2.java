package org.example.service;

import org.example.converter.FluidConverter;
import org.example.converter.WeightConverter;
import org.example.enums.ModuloTipo;
import org.example.model.BaseSpaziale;
import org.example.model.Modulo;

import java.util.List;
import java.util.stream.Collectors;

public class BaseSpazialeServiceImpl2 implements BaseSpazialeService {
    BaseSpaziale baseSpaziale;

    @Override
    public void init(BaseSpaziale baseSpaziale) {
        this.baseSpaziale=baseSpaziale;
    }

    @Override
    public boolean function() {
        List<Modulo> a=this.baseSpaziale.getModuli().stream()
                .filter(b -> b.getModuloTipo().equals(ModuloTipo.STORAGE_WATER))
                .collect(Collectors.toList());
        Double c=a.stream().map(Modulo::getFluid).collect(Collectors.toList())
                .stream().mapToDouble(FluidConverter::getLitri).sum();
        if (c/this.baseSpaziale.getEquipaggio().getFormazione().size()>1500) return true;
        return false;
    }

    @Override
    public boolean checkFood() {
        List<Modulo> listFoodModules=this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_FOOD))
                .collect(Collectors.toList());
        Double food=listFoodModules.stream().map(Modulo::getWeight).collect(Collectors.toList())
                .stream().mapToDouble(WeightConverter::getKili).sum();
        if (food/this.baseSpaziale.getEquipaggio().getFormazione().size()>1600) return true;
        return false;
    }

    @Override
    public boolean checkTrash() {
        List<Modulo> listTrashModules=this.baseSpaziale.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.STORAGE_FOOD))
                .collect(Collectors.toList());
        Double trash=listTrashModules.stream().map(Modulo::getWeight).collect(Collectors.toList())
                .stream().mapToDouble(WeightConverter::getKili).sum();
        if (trash/this.baseSpaziale.getEquipaggio().getFormazione().size()>950) return true;
        return false;
    }
}
