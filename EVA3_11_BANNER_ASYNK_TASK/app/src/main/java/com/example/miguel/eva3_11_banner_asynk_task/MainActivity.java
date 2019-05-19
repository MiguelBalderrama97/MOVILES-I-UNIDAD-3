package com.example.miguel.eva3_11_banner_asynk_task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int speed = 1000;
    private SeekBar sbSpeed;

    private ImageView imgWeather;
    private int index = 0;

    private List<Integer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgWeather = findViewById(R.id.imgWeather);
        sbSpeed = findViewById(R.id.seekBar);

        list.add(R.drawable.light_rain);
        list.add(R.drawable.rainy);
        list.add(R.drawable.snow);

        MiClase obj = new MiClase();
        obj.execute();

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

    class MiClase extends AsyncTask<Integer, String, Void>{
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            imgWeather.setImageResource(list.get(index));
            if (index == 2) {
                index = 0;
            } else {
                index++;
            }
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            while(true){
                try {
                    Thread.sleep(speed);
                    publishProgress();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
