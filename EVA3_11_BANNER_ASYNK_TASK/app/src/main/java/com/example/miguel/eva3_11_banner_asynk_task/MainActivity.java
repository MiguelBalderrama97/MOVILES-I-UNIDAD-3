package com.example.miguel.eva3_11_banner_asynk_task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imgWeather;
    private int index = 0;

    private List<Integer> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgWeather = findViewById(R.id.imgWeather);

        list.add(R.drawable.light_rain);
        list.add(R.drawable.rainy);
        list.add(R.drawable.snow);

        MiClase obj = new MiClase();
        obj.execute();
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
                    Thread.sleep(500);
                    publishProgress();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
