package com.example.miguel.eva3_5_handler_post;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtMsg;

    //    HANDLER
    private Handler handler = new Handler();

    //    UN RUNNABLE QUE VA A INTERACTUAR CON LA INTERFAZ GRAFICA
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
//            AQUI SI PODEMOS INTERACTUAR CON LA UI
            txtMsg.append("Hola mundo\n");
        }
    };

    //    UN HILO QUE HACE EL TRABAJO EN 2DO PLANO
    private Thread thread = new Thread() {
        @Override
        public void run() {
            super.run();
            while (true) {
                try {
                    Thread.sleep(1000);
                    handler.post(runnable);
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
        txtMsg = findViewById(R.id.txtMsg);
        thread.start();
    }
}
