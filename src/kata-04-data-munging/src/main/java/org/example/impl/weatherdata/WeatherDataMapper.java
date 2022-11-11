package org.example.impl.weatherdata;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class WeatherDataMapper {

    public static WeatherData map(String[] line) {
        try {
            return WeatherData.builder()
                    .setDay(Integer.parseInt(line[0]))
                    .setMaxTemp(Double.parseDouble(line[1]))
                    .setMinTemp(Double.parseDouble(line[2]))
                    .setAvgTemp(Double.parseDouble(line[3]))
                    .build();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("Error parsing line %s: %s", Arrays.toString(line), e.getMessage()), e);
        }
    }
}
