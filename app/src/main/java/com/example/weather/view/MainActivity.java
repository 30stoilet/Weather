package com.example.weather.view;


import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.weather.adapters.HM_RecyclerViewAdapter;
import com.example.weather.databinding.ActivityMainBinding;
import com.example.weather.repository.geodata.GeoData;
import com.example.weather.repository.weather.WeatherManager;
import com.example.weather.repository.weather.data.ForecastWeather;
import com.example.weather.repository.weather.data.Hour;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        city = this.getIntent().getStringExtra("city");
        WeatherManager.setWeather(city, this);


        setListeners();
    }


    public void setListeners() {
        binding.TVCurrentLocation.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) && (i == KeyEvent.KEYCODE_ENTER)) {
                    WeatherManager.setWeather(binding.TVCurrentLocation.getText().toString(), MainActivity.this);
                    return true;
                }
                return false;
            }
        });
    }

    public void setCurrentWeather(ForecastWeather forecastWeather) {
        binding.TVCurrentLocation.setText(forecastWeather.getLocation().getName());
        binding.TVMainTemp.setText(String.format("%s", (int)forecastWeather.getCurrent().getTemp_c()));
        binding.TVMaxTemp.setText(String.format("↑%s°C", (int)forecastWeather.getForecast().getForecastday()[0].getDay().getMaxtemp_c()));
        binding.TVMinTemp.setText(String.format("↓%s°C", (int)forecastWeather.getForecast().getForecastday()[0].getDay().getMintemp_c()));
        binding.TVcondition.setText(forecastWeather.getCurrent().getCondition().getText());


        List<Hour> hours = new LinkedList<>();

        Collections.addAll(hours, forecastWeather.getForecast().getForecastday()[0].getHour());
        HM_RecyclerViewAdapter adapter = new HM_RecyclerViewAdapter(hours, this);

        binding.RVhours.setAdapter(adapter);
        binding.RVhours.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        if (this.getIntent().getBooleanExtra("needToSave", false)) {
            try {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(openFileOutput("cities.txt", MODE_PRIVATE)));
                bw.write(binding.TVCurrentLocation.getText().toString() + "\n");
                bw.flush();
                bw.close();
            } catch (Exception ignored) {}
        }
    }

}