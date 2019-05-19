package com.example.miguel.eva3_2_runnable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Thread tMiHilo;

    private Runnable rRun = new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while(true){
                i++;
                try {
                    Log.wtf("HILO",i+" ");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Log.wtf("MSG","HILO INTERRUMPIDO");
                    e.printStackTrace();
                    break;
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tMiHilo = new Thread(rRun);
        tMiHilo.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        tMiHilo.interrupt();
    }
}
