package com.example.miguel.eva3_6_banner;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int speed = 1000;

    private int index = 0;
    private List<Integer> list = new ArrayList();

    private ImageView imgWeather;
    private SeekBar sbSpeed;

    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            imgWeather.setImageResource(list.get(index));
            if (index == 2) {
                index = 0;
            } else {
                index++;
            }
        }
    };

    private Thread thread = new Thread() {
        @Override
        public void run() {
            super.run();
            while (true) {
                try {
                    Thread.sleep(speed);
                    handler.post(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgWeather = findViewById(R.id.imageView);
        sbSpeed = findViewById(R.id.seekBar);
        thread.start();

        list.add(R.drawable.light_rain);
        list.add(R.drawable.rainy);
        list.add(R.drawable.snow);

        sbSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress = 1000 - (progress);
                speed = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
