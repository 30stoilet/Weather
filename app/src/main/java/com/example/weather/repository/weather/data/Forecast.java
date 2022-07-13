package com.example.weather.repository.weather.data;

import java.util.List;

public class Forecast {
    private ForecastDay[] forecastday;

    // GETTER

    public ForecastDay[] getForecastday() {
        return forecastday;
    }

    // SETTER

    public void setForecastday(ForecastDay[] forecastday) {
        this.forecastday = forecastday;
    }
}
