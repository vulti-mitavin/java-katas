package org.example.impl.weatherdata;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDataServiceTest {

    @Test
    void testFindDayWithLeastTempSpreadEmpty() {
        List<WeatherData> weatherData = Collections.emptyList();
        assertEquals(-1, WeatherDataService.findDayWithLeastTempSpread(weatherData));
    }

    @Test
    void testFindDayWithLeastTempSpreadNull() {
        List<WeatherData> weatherData = null;
        assertEquals(-1, WeatherDataService.findDayWithLeastTempSpread(weatherData));
    }

    @Test
    void testFindDayWithLeastTempSpread() {
        WeatherData wd1 = WeatherData.builder()
                .setDay(1)
                .setMaxTemp(100)
                .setMinTemp(80)
                .setAvgTemp(90)
                .build();
        WeatherData wd2 = WeatherData.builder()
                .setDay(2)
                .setMaxTemp(50)
                .setMinTemp(25)
                .setAvgTemp(35)
                .build();
        WeatherData wd3 = WeatherData.builder()
                .setDay(3)
                .setMaxTemp(80)
                .setMinTemp(75)
                .setAvgTemp(78)
                .build();
        List<WeatherData> weatherData = Arrays.asList(wd1, wd2, wd3);
        assertEquals(3, WeatherDataService.findDayWithLeastTempSpread(weatherData));
    }

    @Test
    void testFindDayWithLeastTempSpread_2() {
        List<WeatherData> weatherData = WeatherDataImporter.importData();
        assertEquals(14, WeatherDataService.findDayWithLeastTempSpread(weatherData));
    }
}