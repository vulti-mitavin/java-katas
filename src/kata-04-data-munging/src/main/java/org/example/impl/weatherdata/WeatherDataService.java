package org.example.impl.weatherdata;

import java.util.Comparator;
import java.util.List;

public class WeatherDataService {

    private WeatherDataService() {
    }

    public static int findDayWithLeastTempSpread(List<WeatherData> data) {
        if (data != null && !data.isEmpty()) {
            data.sort(Comparator.comparingDouble(WeatherData::tempSpread));
            return data.get(0).day();
        }
        return -1;
    }
}
