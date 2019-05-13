package com.example.miguel.eva3_13_servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MiServicio extends Service {
    public MiServicio() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("MiSERVICIO", "ONCREATE");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.wtf("MiSERVICIO", "ONSTART");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("MiSERVICIO", "ONDESTROY");
    }
}
