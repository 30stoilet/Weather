package com.example.weather.repository.weather.data;

import java.util.List;

public class ForecastDay {
    private String date;
    private int date_epoch;
    private Day day;
    private Astro astro;
    private Hour[] hour;

    // GETTERS

    public String getDate() {
        return date;
    }

    public int getDate_epoch() {
        return date_epoch;
    }

    public Day getDay() {
        return day;
    }

    public Astro getAstro() {
        return astro;
    }

    public Hour[] getHour() {
        return hour;
    }

    // SETTERS

    public void setDate(String date) {
        this.date = date;
    }

    public void setDate_epoch(int date_epoch) {
        this.date_epoch = date_epoch;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    public void setHour(Hour[] hour) {
        this.hour = hour;
    }
}
