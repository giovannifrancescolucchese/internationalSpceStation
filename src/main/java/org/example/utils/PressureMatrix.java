package org.example.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.model.Astronauta;
import org.example.model.LifeParameter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class PressureMatrix {
    Astronauta astronauta;

    public List<LifeParameter> getLastMinutesLifeParameters(Integer minutes) {
        return this.astronauta.getLifeParameters().stream()
                .filter(lifeParameter ->
                        lifeParameter.getTimestamp().isAfter(LocalDateTime.now().minusMinutes(minutes)))
                .collect(Collectors.toList());
    }

    public boolean isOutOfRangePressureInOneDay() {
        List<LifeParameter> lpList=this.getLastMinutesLifeParameters(1440);
        IntSummaryStatistics stats = lpList
                .stream()
                .mapToInt(LifeParameter::getPressure)
                .summaryStatistics();
        double averagePressure=stats.getAverage();
        Integer astronautaAge=((Long)ChronoUnit.YEARS.between(astronauta.getBirthDate(), LocalDate.now())).intValue();
        if (
                (astronauta.getSesso().equals('F') && (astronautaAge>=20) && (astronautaAge<=30) && (averagePressure>=60) && (averagePressure<=140)) ||
                (astronauta.getSesso().equals('F') && (astronautaAge>=31) && (astronautaAge<=40) && (averagePressure>=70) && (averagePressure<=130)) ||
                (astronauta.getSesso().equals('F') && (astronautaAge>=41) && (astronautaAge<=50) && (averagePressure>=85) && (averagePressure<=125)) ||
                (astronauta.getSesso().equals('F') && (astronautaAge>=51) && (astronautaAge<=60) && (averagePressure>=87) && (averagePressure<=135)) ||
                (astronauta.getSesso().equals('M') && (astronautaAge>=20) && (astronautaAge<=30) && (averagePressure>=70) && (averagePressure<=130)) ||
                (astronauta.getSesso().equals('M') && (astronautaAge>=31) && (astronautaAge<=40) && (averagePressure>=75) && (averagePressure<=125)) ||
                (astronauta.getSesso().equals('M') && (astronautaAge>=41) && (astronautaAge<=50) && (averagePressure>=85) && (averagePressure<=120)) ||
                (astronauta.getSesso().equals('M') && (astronautaAge>=51) && (astronautaAge<=60) && (averagePressure>=87) && (averagePressure<=130))

        ) return false;
        return true;
    }


}
