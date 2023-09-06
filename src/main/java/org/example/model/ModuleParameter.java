package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.ModuloTipo;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ModuleParameter {
    LocalDateTime timestamp;
    Integer co2;

}
