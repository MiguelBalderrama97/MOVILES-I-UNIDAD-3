package com.example.miguel.eva_3_15_media_player;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mpReproductor = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mpReproductor = MediaPlayer.create(MainActivity.this, R.raw.cancion);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mpReproductor != null){
            mpReproductor.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mpReproductor != null){
            mpReproductor.stop();
            mpReproductor.release();
        }
    }
}
