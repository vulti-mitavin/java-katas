package org.example.impl.weatherdata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherDataImporterTest {

    @Test
    void importDataTest() {
        List<WeatherData> data = WeatherDataImporter.importData();
        assertEquals(new WeatherData(1, 88, 59, 74), data.get(0));
    }
}