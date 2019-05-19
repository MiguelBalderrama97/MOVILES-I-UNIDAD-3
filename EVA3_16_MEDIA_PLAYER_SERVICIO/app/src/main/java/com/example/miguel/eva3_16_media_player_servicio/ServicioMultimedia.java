package com.example.miguel.eva3_16_media_player_servicio;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class ServicioMultimedia extends Service {

    private MediaPlayer nMultimedia = null;

    public ServicioMultimedia() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        nMultimedia = MediaPlayer.create(getApplicationContext(), R.raw.cancion);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(nMultimedia != null){
            nMultimedia.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(nMultimedia != null){
            nMultimedia.stop();
            nMultimedia.release();
        }
    }
}
