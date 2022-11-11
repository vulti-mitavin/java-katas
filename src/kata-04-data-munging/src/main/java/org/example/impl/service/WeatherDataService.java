package org.example.impl.service;

import lombok.experimental.UtilityClass;
import org.example.impl.model.WeatherData;

import java.util.Comparator;
import java.util.List;

@UtilityClass
public class WeatherDataService {

    public static int findDayWithLeastTempSpread(List<WeatherData> data) {
        if (data != null && !data.isEmpty()) {
            data.sort(Comparator.comparingDouble(WeatherData::tempSpread));
            return data.get(0).day();
        }
        return -1;
    }
}
