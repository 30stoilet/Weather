package com.example.weather.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.weather.R;
import com.example.weather.databinding.ActivityStarterBinding;
import com.example.weather.repository.geodata.GeoData;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class StarterActivity extends AppCompatActivity {
    private ActivityStarterBinding binding;
    private volatile String city = null;
    private boolean needToSave = false;

    public void setLocation(Location location) {
        this.city = location.getLatitude() + "," + location.getLongitude();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStarterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setAnimation();
    }

    private void setAnimation() {
        Animation animation = AnimationUtils.loadAnimation(StarterActivity.this, R.anim.appearing);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                try {
                    BufferedReader bf = new BufferedReader(new InputStreamReader(openFileInput("cities.txt")));
                    city = bf.readLine();
                    bf.close();
                    if (city == "") {
                        needToSave = true;
                        new GeoData(StarterActivity.this).getLastLocation();
                        city = null;
                    }
                } catch (Exception ex) {
                    needToSave = true;
                    new GeoData(StarterActivity.this).getLastLocation();
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (city == null) {}
                        Intent intent = new Intent(StarterActivity.this, MainActivity.class);
                        intent.putExtra("needToSave", needToSave);
                        intent.putExtra("city", city);
                        startActivity(intent);
                    }
                }).start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        binding.TVtmp.startAnimation(animation);
    }
}