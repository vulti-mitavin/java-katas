package ch.grassl.impl.importer;

import ch.grassl.impl.model.WeatherData;
import ch.grassl.impl.util.Constants;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDataImporterTest {

    private final WeatherDataImporter importer = new WeatherDataImporter();

    @Test
    void importDataTest() {
        List<WeatherData> data = importer.importData(Constants.WEATHER_DATA_RESOURCE);
        assertEquals(new WeatherData(1, 88, 59, 74), data.get(0));
    }

    @Test
    void lineMapTest() {
        String[] line = new String[]{"1", "1.0", "2.0", "3.0"};
        WeatherData wd = importer.map(line);
        assertEquals(1, wd.day());
        assertEquals(1.0, wd.maxTemp());
        assertEquals(2.0, wd.minTemp());
        assertEquals(3.0, wd.avgTemp());
    }

    @Test
    void lineMapTestIllegalValue() {
        String[] line = new String[]{"mon", "1.0", "2.0", "3.0"};
        assertThrows(IllegalArgumentException.class, () -> importer.map(line));
    }
}