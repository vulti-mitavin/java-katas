package org.example.impl.weatherdata;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDataTest {

    @Test
    void testTempSpread() {
        WeatherData wd = WeatherData.builder()
                .setMaxTemp(10)
                .setMinTemp(8)
                .build();
        assertEquals(2, wd.tempSpread());
    }

    @Test
    void testTempSpread2() {
        DecimalFormat df = new DecimalFormat("0.##");
        DecimalFormatSymbols dfSymbols = DecimalFormatSymbols.getInstance();
        dfSymbols.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfSymbols);
        WeatherData wd = WeatherData.builder()
                .setMaxTemp(10.333)
                .setMinTemp(8.123)
                .build();
        assertEquals("2.21", df.format(wd.tempSpread()));
    }
}