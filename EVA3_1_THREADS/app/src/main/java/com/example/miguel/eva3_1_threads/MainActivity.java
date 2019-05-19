package com.example.miguel.eva3_1_threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private Thread tMiHilo = new Thread(){
        @Override
        public void run() {
            super.run();
            for (int i = 0; i<20;i++){
                try{
                    Log.wtf("HILO",i+"");
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tMiHilo.start();
    }
}
