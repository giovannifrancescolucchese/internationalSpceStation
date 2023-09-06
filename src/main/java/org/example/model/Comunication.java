package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.ComunicationType;

@Data
@AllArgsConstructor
public class Comunication {
    String testo;
    ComunicationType comunicationType;
}
