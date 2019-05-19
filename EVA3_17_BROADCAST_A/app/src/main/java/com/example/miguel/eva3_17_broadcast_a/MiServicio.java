package com.example.miguel.eva3_17_broadcast_a;

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
        tHilo.interrupt();
    }
}
