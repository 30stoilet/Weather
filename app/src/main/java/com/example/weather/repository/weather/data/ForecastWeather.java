package com.example.weather.repository.weather.data;

public class ForecastWeather {
    private Location location;
    private Current current;
    private Forecast forecast;

    // GETTERS
    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    // SETTERS
    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
