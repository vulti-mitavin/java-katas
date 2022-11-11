package org.example.impl.weatherdata;

import java.util.Objects;

public final class WeatherData {

    private int day;
    private double maxTemp;
    private double minTemp;
    private double avgTemp;

    private WeatherData() {
    }

    public WeatherData(int day, double maxTemp, double minTemp, double avgTemp) {
        this.day = day;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.avgTemp = avgTemp;
    }

    public double tempSpread() {
        return maxTemp - minTemp;
    }

    public static WeatherDataBuilder builder() {
        return new WeatherDataBuilder();
    }

    public static class WeatherDataBuilder {
        private final WeatherData wd = new WeatherData();

        public WeatherDataBuilder setDay(int day) {
            wd.day = day;
            return this;
        }

        public WeatherDataBuilder setMaxTemp(double maxTemp) {
            wd.maxTemp = maxTemp;
            return this;
        }

        public WeatherDataBuilder setMinTemp(double minTemp) {
            wd.minTemp = minTemp;
            return this;
        }

        public WeatherDataBuilder setAvgTemp(double avgTemp) {
            wd.avgTemp = avgTemp;
            return this;
        }

        public WeatherData build() {
            return wd;
        }
    }

    public int day() {
        return day;
    }

    public double maxTemp() {
        return maxTemp;
    }

    public double minTemp() {
        return minTemp;
    }

    public double avgTemp() {
        return avgTemp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (WeatherData) obj;
        return this.day == that.day &&
                Double.doubleToLongBits(this.maxTemp) == Double.doubleToLongBits(that.maxTemp) &&
                Double.doubleToLongBits(this.minTemp) == Double.doubleToLongBits(that.minTemp) &&
                Double.doubleToLongBits(this.avgTemp) == Double.doubleToLongBits(that.avgTemp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, maxTemp, minTemp, avgTemp);
    }

    @Override
    public String toString() {
        return "WeatherData[" +
                "day=" + day + ", " +
                "maxTemp=" + maxTemp + ", " +
                "minTemp=" + minTemp + ", " +
                "avgTemp=" + avgTemp + ']';
    }

}
