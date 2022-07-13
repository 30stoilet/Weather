package com.example.weather.adapters.models;

public class HourModel {
    private String temperature;
    private int icon_id;
    private String time;

    public HourModel(String temperature, int icon_id, String time) {
        this.temperature = temperature;
        this.icon_id = icon_id;
        this.time = time;
    }

    // GETTERS

    public String getTemperature() {
        return temperature;
    }

    public int getIcon_id() {
        return icon_id;
    }

    public String getTime() {
        return time;
    }
}
