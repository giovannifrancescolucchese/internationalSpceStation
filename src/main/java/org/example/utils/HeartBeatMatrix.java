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

/**
 * This class is responsible for managing and analyzing an astronaut's life parameters,
 * specifically focusing on heart rate data. It can retrieve recent life parameters and
 * evaluate if an astronaut's heart rate is within expected range given their age and gender.
 */
@Data
@AllArgsConstructor
public class HeartBeatMatrix {
    Astronauta astronauta; // Represents the astronaut whose life parameters are analyzed.

    /**
     * Retrieves the life parameters for the last specified number of minutes.
     * @param minutes The period in minutes for which to retrieve life parameters.
     * @return A list of life parameters occurring within the last specified minutes.
     */
    public List<LifeParameter> getLastMinutesLifeParameters(Integer minutes) {
        // Use Stream API to filter life parameters by timestamp,
        // returning only those within the specified timeframe.
        return this.astronauta.getLifeParameters().stream()
                .filter(lifeParameter ->
                        lifeParameter.getTimestamp().isAfter(LocalDateTime.now().minusMinutes(minutes)))
                .collect(Collectors.toList());
    }

    /**
     * Checks if the astronaut's heart rate over the last 7 minutes is out of the expected range,
     * considering their age and gender.
     * @return true if the heart rate is out of the expected range, false otherwise.
     */
    public boolean isOutOfRangeHeartBeatLast7Minutes() {
        // Get life parameters from the last 7 minutes.
        List<LifeParameter> lpList = this.getLastMinutesLifeParameters(7);

        // Extract heart rate statistics from the life parameters.
        IntSummaryStatistics stats = lpList.stream()
                .mapToInt(LifeParameter::getHeartRate)
                .summaryStatistics();

        double averageHeartBeat = stats.getAverage();
        Integer astronautaAge = ((Long) ChronoUnit.YEARS.between(astronauta.getBirthDate(), LocalDate.now())).intValue();

        // Check the heart rate against age and gender-specific thresholds.
        if ((astronauta.getSesso().equals('F') && (astronautaAge >= 20) && (astronautaAge <= 30) && (averageHeartBeat >= 45) && (averageHeartBeat <= 75)) ||
                (astronauta.getSesso().equals('F') && (astronautaAge >= 31) && (astronautaAge <= 40) && (averageHeartBeat >= 50) && (averageHeartBeat <= 80)) ||
                (astronauta.getSesso().equals('F') && (astronautaAge >= 41) && (astronautaAge <= 50) && (averageHeartBeat >= 55) && (averageHeartBeat <= 85)) ||
                (astronauta.getSesso().equals('F') && (astronautaAge >= 51) && (astronautaAge <= 60) && (averageHeartBeat >= 65) && (averageHeartBeat <= 90)) ||
                (astronauta.getSesso().equals('M') && (astronautaAge >= 20) && (astronautaAge <= 30) && (averageHeartBeat >= 50) && (averageHeartBeat <= 70)) ||
                (astronauta.getSesso().equals('M') && (astronautaAge >= 31) && (astronautaAge <= 40) && (averageHeartBeat >= 55) && (averageHeartBeat <= 75)) ||
                (astronauta.getSesso().equals('M') && (astronautaAge >= 41) && (astronautaAge <= 50) && (averageHeartBeat >= 60) && (averageHeartBeat <= 80)) ||
                (astronauta.getSesso().equals('M') && (astronautaAge >= 51) && (astronautaAge <= 60) && (averageHeartBeat >= 65) && (averageHeartBeat <= 85)))
            return false;

        return true;
    }
}