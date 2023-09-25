package org.example.service;

import org.example.enums.ComunicationType;
import org.example.model.Astronauta;
import org.example.model.Comunication;
import org.example.utils.HeartBeatMatrix;
import org.example.utils.PressureMatrix;

public class ComuncationServiceImpl implements ComunicationService{
    @Override
    public Comunication createHealthComunicazioneHeartBeat(Astronauta astronauta, HeartBeatMatrix heartBeatMatrix) {
        heartBeatMatrix.setAstronauta(astronauta);
        if (heartBeatMatrix.isOutOfRangeHeartBeatLast7Minutes())
            return new Comunication("problemi cardiaci", ComunicationType.PARAMETRI_VITALI);
        return null;
    }

    @Override
    public Comunication createHealthComunicazionePressure(Astronauta astronauta, PressureMatrix pressureMatrix) {
        pressureMatrix.setAstronauta(astronauta);
        if (pressureMatrix.isOutOfRangePressureInOneDay())
            return new Comunication("problemi pressione", ComunicationType.PARAMETRI_VITALI);
        return null;
    }

    @Override
    public Comunication createComunicazioneFood(BaseSpazialeService baseSpazialeService) {
        if (baseSpazialeService.checkFood())
            return new Comunication("scorte cibo sotto controllo", ComunicationType.SERVIZIO);
        return new Comunication("ALERT: scorte cibo in esaurimento", ComunicationType.SERVIZIO);
    }

    @Override
    public Comunication createComunicazioneWater(BaseSpazialeService baseSpazialeService) {
        if (!baseSpazialeService.checkWater())
            return new Comunication("ALERT: scorta acqua in esaurimento", ComunicationType.SERVIZIO);
        return new Comunication("scorte acqua sotto controllo", ComunicationType.SERVIZIO);
    }

    @Override
    public Comunication createComunicazioneTrash(BaseSpazialeService baseSpazialeService) {
        if (!baseSpazialeService.checkTrash())
            return new Comunication("ALERT: espellere la spazzatura", ComunicationType.SERVIZIO);
        return new Comunication("capacità spazzatura sotto controllo", ComunicationType.SERVIZIO);
    }
}
