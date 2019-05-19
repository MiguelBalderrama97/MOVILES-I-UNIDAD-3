package com.example.miguel.eva3_14_broadcast_receiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MiServicio extends Service {

    private Thread tHilo;
    private Intent inMensaje;

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
        Log.wtf("MISERVICIO", "ONCREATE");
        inMensaje = new Intent("MI_SERVICIO");
        inMensaje.putExtra("MENSAJE", "onCreate");
        sendBroadcast(inMensaje);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.wtf("MISERVICIO", "ONSTART");

        tHilo = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        inMensaje = new Intent("MI_SERVICIO");
        inMensaje.putExtra("MENSAJE", "onStart");
        sendBroadcast(inMensaje);
        tHilo.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("MISERVICIO", "ONDESTROY");
        inMensaje = new Intent("MI_SERVICIO");
        inMensaje.putExtra("MENSAJE", "onDestroy");
        sendBroadcast(inMensaje);
        tHilo.interrupt();
    }
}
