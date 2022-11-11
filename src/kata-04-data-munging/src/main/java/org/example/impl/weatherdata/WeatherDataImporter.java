package org.example.impl.weatherdata;

import org.example.impl.file.ResourceReader;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataImporter {

    public static final int DATA_LINES_START = 1;
    public static final String WEATHER_DATA_RESOURCE = "/weather.dat";

    private static List<String[]> rawData = new ArrayList<>();
    private static final List<WeatherData> data = new ArrayList<>();

    private WeatherDataImporter() {
        // should not be instantiated
    }

    public static List<WeatherData> importData() {
        rawData = ResourceReader.read(WEATHER_DATA_RESOURCE, 0, 4);
        for (int line = DATA_LINES_START; line < rawData.size(); line++) {
            try {
                data.add(getWeatherDataFromLine(line));
            } catch (IllegalArgumentException ignore) {
                // Do nothing
            }
        }
        return data;
    }

    private static WeatherData getWeatherDataFromLine(int index) {
        String[] line = rawData.get(index);
        return WeatherDataMapper.map(line);
    }
}
