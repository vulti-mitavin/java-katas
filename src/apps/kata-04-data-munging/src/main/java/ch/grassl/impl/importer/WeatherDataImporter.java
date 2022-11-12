package ch.grassl.impl.importer;

import ch.grassl.impl.model.WeatherData;

import java.util.Arrays;

public class WeatherDataImporter extends AbstractDataImporter<WeatherData> {

    public WeatherDataImporter() {
        super(0, 4);
    }

    @Override
    public WeatherData map(String[] line) {
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
