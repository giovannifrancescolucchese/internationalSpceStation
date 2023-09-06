package org.example.service;

import org.example.model.BaseSpaziale;

public interface BaseSpazialeService {
    void init(BaseSpaziale baseSpaziale);

    boolean checkWater();
    boolean checkFood();
    boolean checkTrash();
}
