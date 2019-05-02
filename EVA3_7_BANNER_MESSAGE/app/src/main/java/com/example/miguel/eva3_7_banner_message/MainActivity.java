package com.example.miguel.eva3_7_banner_message;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int speed = 1;

    private int index = 0;
    private List<Integer> list = new ArrayList();

    private ImageView imgWeather;
    private SeekBar sbSpeed;


    private Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
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
                    Message msgMensa = handler.obtainMessage();
                    handler.sendMessage(msgMensa);
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

        imgWeather = findViewById(R.id.imgWeather);
        sbSpeed = findViewById(R.id.sbSpeed);

        list.add(R.drawable.light_rain);
        list.add(R.drawable.rainy);
        list.add(R.drawable.snow);

        thread.start();

        sbSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
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
