package org.example.service;

import org.example.model.Astronauta;
import org.example.model.Comunication;
import org.example.utils.HeartBeatMatrix;
import org.example.utils.PressureMatrix;

/**
 * The ComunicationService interface defines methods to create various types of communications
 * from a space environment context. These communications include health statuses of an astronaut
 * based on heart rate and pressure, as well as routine operational communications about food,
 * water, and trash management in a space station.
 */
public interface ComunicationService {

    /**
     * Creates a health communication message related to the heart beat of an astronaut.
     *
     * @param astronauta The astronaut for whom the health communication is being created.
     * @param heartBeatMatrix The data matrix containing heart beat information used to generate the communication.
     * @return Comunication A communication instance containing the heart beat health message.
     */
    Comunication createHealthComunicazioneHeartBeat(Astronauta astronauta, HeartBeatMatrix heartBeatMatrix);

    /**
     * Creates a health communication message related to the pressure measurements of an astronaut.
     *
     * @param astronauta The astronaut for whom the pressure communication is being created.
     * @param pressureMatrix The data matrix containing pressure measurement information used to generate the communication.
     * @return Comunication A communication instance containing the pressure health message.
     */
    Comunication createHealthComunicazionePressure(Astronauta astronauta, PressureMatrix pressureMatrix);

    /**
     * Creates a communication message concerning the delivery or status of food in a space station.
     *
     * @param baseSpazialeService The service representing operations of a space station that is involved in the management of food.
     * @return Comunication A communication instance containing information regarding food management.
     */
    Comunication createComunicazioneFood(BaseSpazialeService baseSpazialeService);

    /**
     * Creates a communication message concerning the delivery or status of water in a space station.
     *
     * @param baseSpazialeService The service representing operations of a space station that is involved in the management of water.
     * @return Comunication A communication instance containing information regarding water management.
     */
    Comunication createComunicazioneWater(BaseSpazialeService baseSpazialeService);

    /**
     * Creates a communication message concerning the management or disposal of trash in a space station.
     *
     * @param baseSpazialeService The service representing operations of a space station that is involved in the management of trash.
     * @return Comunication A communication instance containing information regarding trash management.
     */
    Comunication createComunicazioneTrash(BaseSpazialeService baseSpazialeService);
}