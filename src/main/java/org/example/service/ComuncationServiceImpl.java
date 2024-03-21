package org.example.service;

import org.example.enums.ComunicationType;
import org.example.model.Astronauta;
import org.example.model.Comunication;
import org.example.utils.HeartBeatMatrix;
import org.example.utils.PressureMatrix;

/**
 * Implements the ComunicationService interface to provide methods for generating
 * communication messages based on various conditions such as heart beat, blood pressure,
 * food, water, and trash capacity in a space environment. Primarily focused on monitoring the health
 * and environment parameters and generating respective alert or status messages.
 */
public class ComuncationServiceImpl implements ComunicationService {

    /**
     * Creates a communication regarding an astronaut's heart condition based on the last 7 minutes of data.
     *
     * @param astronauta The astronaut whose heart beat data is evaluated.
     * @param heartBeatMatrix The data object containing heart beat data.
     * @return A communication message about heart condition or null if parameters are normal.
     */
    @Override
    public Comunication createHealthComunicazioneHeartBeat(Astronauta astronauta, HeartBeatMatrix heartBeatMatrix) {
        heartBeatMatrix.setAstronauta(astronauta); // Associate the astronaut with the heart beat data.
        // Check if the heart beat data is out of range in the last 7 minutes.
        if (heartBeatMatrix.isOutOfRangeHeartBeatLast7Minutes())
            return new Comunication("problemi cardiaci", ComunicationType.PARAMETRI_VITALI);
        return null; // Return null if the heart beat is within the normal range.
    }

    /**
     * Creates a communication regarding an astronaut's blood pressure based on the last day data.
     *
     * @param astronauta The astronaut whose blood pressure data is evaluated.
     * @param pressureMatrix The data object containing pressure data.
     * @return A communication message about blood pressure condition or null if parameters are normal.
     */
    @Override
    public Comunication createHealthComunicazionePressure(Astronauta astronauta, PressureMatrix pressureMatrix) {
        pressureMatrix.setAstronauta(astronauta); // Associate the astronaut with the pressure data.
        // Check if the pressure data is out of range in the last day.
        if (pressureMatrix.isOutOfRangePressureInOneDay())
            return new Comunication("problemi pressione", ComunicationType.PARAMETRI_VITALI);
        return null; // Return null if the pressure is within the normal range.
    }

    /**
     * Creates a communication about the food supply status in the space station.
     *
     * @param baseSpazialeService Provides services related to the space base operations.
     * @return A communication message indicating the status of food supplies.
     */
    @Override
    public Comunication createComunicazioneFood(BaseSpazialeService baseSpazialeService) {
        // Check if the food availability is sufficient.
        if (baseSpazialeService.checkFoodAvailability())
            return new Comunication("scorte cibo sotto controllo", ComunicationType.SERVIZIO);
        // Generate alert if the food supplies are running low.
        return new Comunication("ALERT: scorte cibo in esaurimento", ComunicationType.SERVIZIO);
    }

    /**
     * Creates a communication about the water supply status in the space station.
     *
     * @param baseSpazialeService Provides services related to the space base operations.
     * @return A communication message indicating the status of water supplies.
     */
    @Override
    public Comunication createComunicazioneWater(BaseSpazialeService baseSpazialeService) {
        // Check if the water availability is sufficient.
        if (baseSpazialeService.checkWaterAvailability())
            return new Comunication("scorte acqua sotto controllo", ComunicationType.SERVIZIO);
        // Generate alert if the water supplies are running low.
        return new Comunication("ALERT: scorta acqua in esaurimento", ComunicationType.SERVIZIO);
    }

    /**
     * Creates a communication about the trash capacity status in the space station.
     *
     * @param baseSpazialeService Provides services related to the space base operations.
     * @return A communication message indicating whether the trash capacity is under control or needs action.
     */
    @Override
    public Comunication createComunicazioneTrash(BaseSpazialeService baseSpazialeService) {
        // Check if the trash capacity is under control.
        if (baseSpazialeService.checkTrashCapacity())
            return new Comunication("capacità spazzatura sotto controllo", ComunicationType.SERVIZIO);
        // Generate alert if the trash needs to be expelled due to overcapacity.
        return new Comunication("ALERT: espellere la spazzatura", ComunicationType.SERVIZIO);
    }
}