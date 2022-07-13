package com.example.weather.repository.weather.data;

public class Location {
    private String name;
    private String region;
    private String country;
    private double lat;
    private double lon;
    private String tz_id;
    private int localtime_epoch;
    private String localtime;

    // GETTERS
    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getTz_id() {
        return tz_id;
    }

    public int getLocaltime_epoch() {
        return localtime_epoch;
    }

    public String getLocaltime() {
        return localtime;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setTz_id(String tz_id) {
        this.tz_id = tz_id;
    }

    public void setLocaltime_epoch(int localtime_epoch) {
        this.localtime_epoch = localtime_epoch;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }
}
