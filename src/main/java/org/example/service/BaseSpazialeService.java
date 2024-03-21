package org.example.service;

import org.example.model.BaseSpaziale;

/**
 * The {@code BaseSpazialeService} interface defines operations that can be performed
 * on a space base entity. This includes initializing a space base, and checking its
 * resources like water, food, and trash capacity. It is intended to be implemented
 * by classes that manage the state and resources of a space base, ensuring that
 * it can sustain its inhabitants by providing essential services.
 */
public interface BaseSpazialeService {

    /**
     * Initializes the given space base entity with necessary settings or resources.
     * This could include preparing the habitat by setting up life-support systems,
     * resource allocations, and any initial setup required for the space base to function.
     *
     * @param baseSpaziale The {@code BaseSpaziale} instance to be initialized.
     */
    void init(BaseSpaziale baseSpaziale);

    /**
     * Checks if the space base has sufficient water availability for its needs.
     * This might involve assessing stored water levels against consumption rates
     * and determining whether the available supply is adequate.
     *
     * @return {@code true} if the water availability is sufficient, {@code false} otherwise.
     */
    boolean checkWaterAvailability();

    /**
     * Checks if the space base has enough food available for its inhabitants.
     * This could be evaluated based on current food stockpiles, the rate of consumption,
     * and the capacity to produce or procure more food as needed.
     *
     * @return {@code true} if the food availability meets or exceeds requirements, {@code false} otherwise.
     */
    boolean checkFoodAvailability();

    /**
     * Assesses whether the space base's trash disposal capabilities are within capacity.
     * This method is important for maintaining the habitability and cleanliness of the
     * environment, ensuring that waste management does not exceed the base's capacity to
     * effectively manage and dispose of trash.
     *
     * @return {@code true} if the trash capacity is within acceptable limits, {@code false} otherwise.
     */
    boolean checkTrashCapacity();
}