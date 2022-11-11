package org.example.impl.weatherdata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDataMapperTest {

    @Test
    void lineMapTest() {
        String[] line = new String[]{"1", "1.0", "2.0", "3.0"};
        WeatherData wd = WeatherDataMapper.map(line);
        assertEquals(1, wd.day());
        assertEquals(1.0, wd.maxTemp());
        assertEquals(2.0, wd.minTemp());
        assertEquals(3.0, wd.avgTemp());
    }

    @Test
    void lineMapTestIllegalValue() {
        String[] line = new String[]{"mon", "1.0", "2.0", "3.0"};
        assertThrows(IllegalArgumentException.class, () -> WeatherDataMapper.map(line));
    }
}