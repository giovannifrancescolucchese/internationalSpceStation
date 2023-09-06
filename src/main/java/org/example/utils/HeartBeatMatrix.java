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
public class HeartBeatMatrix {
    Astronauta astronauta;

    public List<LifeParameter> getLastMinutesLifeParameters(Integer minutes) {
        return this.astronauta.getLifeParameters().stream()
                .filter(lifeParameter ->
                        lifeParameter.getTimestamp().isAfter(LocalDateTime.now().minusMinutes(minutes)))
                .collect(Collectors.toList());
    }

    public boolean isOutOfRangeHeartBeatLast7Minutes() {
        List<LifeParameter> lpList=this.getLastMinutesLifeParameters(7);
        IntSummaryStatistics stats = lpList
                .stream()
                .mapToInt(LifeParameter::getHeartRate)
                .summaryStatistics();
        double averageHeartBeat=stats.getAverage();
        Integer astronautaAge=((Long) ChronoUnit.YEARS.between(astronauta.getBirthDate(), LocalDate.now())).intValue();
        if (
                        (astronauta.getSesso().equals('F') && (astronautaAge>=20) && (astronautaAge<=30) && (averageHeartBeat>=45) && (averageHeartBeat<=75)) ||
                        (astronauta.getSesso().equals('F') && (astronautaAge>=31) && (astronautaAge<=40) && (averageHeartBeat>=50) && (averageHeartBeat<=80)) ||
                        (astronauta.getSesso().equals('F') && (astronautaAge>=41) && (astronautaAge<=50) && (averageHeartBeat>=55) && (averageHeartBeat<=85)) ||
                        (astronauta.getSesso().equals('F') && (astronautaAge>=51) && (astronautaAge<=60) && (averageHeartBeat>=65) && (averageHeartBeat<=90)) ||
                        (astronauta.getSesso().equals('M') && (astronautaAge>=20) && (astronautaAge<=30) && (averageHeartBeat>=50) && (averageHeartBeat<=70)) ||
                        (astronauta.getSesso().equals('M') && (astronautaAge>=31) && (astronautaAge<=40) && (averageHeartBeat>=55) && (averageHeartBeat<=75)) ||
                        (astronauta.getSesso().equals('M') && (astronautaAge>=41) && (astronautaAge<=50) && (averageHeartBeat>=60) && (averageHeartBeat<=80)) ||
                        (astronauta.getSesso().equals('M') && (astronautaAge>=51) && (astronautaAge<=60) && (averageHeartBeat>=65) && (averageHeartBeat<=85))

        ) return false;
        return true;
    }

}

