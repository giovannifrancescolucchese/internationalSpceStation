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
 * Provides utility methods for analyzing pressure-related life parameters of an astronaut.
 * This class acts as a utility to determine if an astronaut's vital signs related to pressure
 * deviate from expected ranges based on age and gender.
 */
@Data
@AllArgsConstructor
public class PressureMatrix {
    // The astronaut whose life parameters are analyzed.
    Astronauta astronauta;

    /**
     * Retrieves life parameters of the astronaut for the last specified minutes.
     *
     * @param minutes The duration in minutes for which to retrieve life parameters.
     * @return A list of life parameters recorded in the last specified minutes.
     */
    public List<LifeParameter> getLastMinutesLifeParameters(Integer minutes) {
        return this.astronauta.getLifeParameters().stream()
                // Filter life parameters within the last specified minutes
                .filter(lifeParameter ->
                        lifeParameter.getTimestamp().isAfter(LocalDateTime.now().minusMinutes(minutes)))
                .collect(Collectors.toList());
    }

    /**
     * Determines if the astronaut's pressure readings are out of expected range based on their age and gender over a one-day period.
     * The method evaluates the average pressure against predefined thresholds.
     *
     * @return true if the average pressure over the last day is out of the expected range, false otherwise.
     */
    public boolean isOutOfRangePressureInOneDay() {
        // Retrieve the last 1440 minutes (1 day) of life parameters.
        List<LifeParameter> lpList=this.getLastMinutesLifeParameters(1440);
        // Generate statistics on the pressure values
        IntSummaryStatistics stats = lpList
                .stream()
                .mapToInt(LifeParameter::getPressure)
                .summaryStatistics();
        double averagePressure=stats.getAverage();
        // Calculate astronaut's age
        Integer astronautaAge=((Long)ChronoUnit.YEARS.between(astronauta.getBirthDate(), LocalDate.now())).intValue();
        // Check the average pressure against thresholds based on gender and age
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