package com.example.miguel.eva3_3_sincronizacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtHW;
    private Thread tHilo = new Thread(){
        @Override
        public void run() {
            super.run();
            while(true){
                txtHW.setText("MODIFICADO POR HILO");
                try {
                    Thread.sleep(1000);
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

        txtHW = findViewById(R.id.txtHW);
        txtHW.setText("AQUI NO HAY FALLA");
        tHilo.start();
    }
}
