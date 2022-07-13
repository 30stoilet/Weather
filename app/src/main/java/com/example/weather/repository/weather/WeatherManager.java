package com.example.weather.repository.weather;

import com.example.weather.view.MainActivity;
import com.example.weather.repository.weather.data.ForecastWeather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherManager {
    private static final String API_KEY = "248a249476cd458ab38140300221902";
    private static final String URL = "https://api.weatherapi.com/";
    private static final String AQI = "no";
    private static final String ALERTS = "no";

    public static void setWeather(String cityOrCoordinates, MainActivity mainActivity) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ForecastWeatherAPICall APIcall = retrofit.create(ForecastWeatherAPICall.class);
        Call<ForecastWeather> call = APIcall.getData(API_KEY, cityOrCoordinates, 1, AQI, ALERTS);

        call.enqueue(new Callback<ForecastWeather>() {
            @Override
            public void onResponse(Call<ForecastWeather> call, Response<ForecastWeather> response) {
                if (response.code() == 200) {
                    mainActivity.setCurrentWeather(response.body());
                }
            }

            @Override
            public void onFailure(Call<ForecastWeather> call, Throwable t) {

            }
        });
    }
}
