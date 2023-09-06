package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.ModuloTipo;

import java.util.List;

@Data
@AllArgsConstructor
public class BaseSpaziale {
    List<Modulo> moduli;
    Equipaggio equipaggio;

    public Integer getPostiLetto() {
        return this.getModuli().stream()
                .filter(modulo -> modulo.getModuloTipo().equals(ModuloTipo.DORMITORIO))
                .mapToInt(Modulo::getPostazioni).sum();
    }
}
