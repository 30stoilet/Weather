package com.example.weather.repository.weather;

import com.example.weather.repository.weather.data.ForecastWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ForecastWeatherAPICall {
    // http://api.weatherapi.com/v1/    current.json?key=248a249476cd458ab38140300221902&q=London&aqi=no
    @GET("v1/forecast.json")
    Call<ForecastWeather> getData(@Query("key") String APIkey, @Query("q") String city, @Query("days") int days, @Query("aqi") String aqi, @Query("alerts") String alerts);
}
