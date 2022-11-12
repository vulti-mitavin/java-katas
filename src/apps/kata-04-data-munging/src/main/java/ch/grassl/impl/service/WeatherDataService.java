package ch.grassl.impl.service;

import ch.grassl.impl.model.WeatherData;
import lombok.experimental.UtilityClass;

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
