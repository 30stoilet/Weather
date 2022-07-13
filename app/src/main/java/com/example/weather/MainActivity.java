package com.example.weather;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.example.weather.databinding.ActivityMainBinding;
import com.example.weather.repository.geodata.GeoData;
import com.example.weather.repository.weather.WeatherManager;
import com.example.weather.repository.weather.data.ForecastWeather;


public class MainActivity extends AppCompatActivity {

    protected ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        starterValues();
        setListeners();
    }

    public void starterValues() {
        GeoData geoData = new GeoData(this);
        geoData.getLastLocation();
    }

    public void setListeners() {
        binding.ETcity.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (i == KeyEvent.KEYCODE_ENTER)) {
                    WeatherManager.setWeather(binding.ETcity.getText().toString(), MainActivity.this);
                    return true;
                }
                return false;
            }
        });
    }

    public void setCurrentWeather(ForecastWeather forecastWeather) {
        binding.ETcity.setText(forecastWeather.getLocation().getName());
        binding.TVtemperature.setText(String.format("%s", forecastWeather.getCurrent().getTemp_c()));
        binding.TVLowestHighestTemperature.setText(String.format("↑%s°C ↓%s°C", forecastWeather.getForecast().getForecastday()[0].getDay().getMaxtemp_c(), forecastWeather.getForecast().getForecastday()[0].getDay().getMintemp_c()));
        binding.TVstatus.setText(forecastWeather.getCurrent().getCondition().getText());
    }

}