package org.example.service;

import org.example.model.Astronauta;
import org.example.model.Comunication;
import org.example.utils.HeartBeatMatrix;
import org.example.utils.PressureMatrix;

public interface ComunicationService {

    Comunication createHealthComunicazioneHeartBeat(Astronauta astronauta, HeartBeatMatrix heartBeatMatrix);
    Comunication createHealthComunicazionePressure(Astronauta astronauta, PressureMatrix pressureMatrix);
    Comunication createComunicazioneFood(BaseSpazialeService baseSpazialeService);
    Comunication createComunicazioneWater(BaseSpazialeService baseSpazialeService);
    Comunication createComunicazioneTrash(BaseSpazialeService baseSpazialeService);


}
