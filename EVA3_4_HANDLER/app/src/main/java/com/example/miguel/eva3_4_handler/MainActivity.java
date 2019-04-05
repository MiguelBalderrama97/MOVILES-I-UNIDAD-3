package com.example.miguel.eva3_4_handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView txtHW;

    private final int HILO_CHAFA = 10;
    private final int HILO_CHAFA2 = 20;

    private Handler hMiHanlder = new Handler(){
//        ESTE METODO YA PERTENECE AL HILO PRINCIPAL
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            SE PUEDE INTERACTUAR CON LA INTERFAZ GRÁFICA PERO CON TRABAJO LIGERO
            int iVal = (int)msg.obj;
            txtHW.setText("HILO = " + msg.what + ", Contador = " + iVal);
        }
    };

    private Thread tHilo = new Thread(){
        @Override
        public void run() {
            super.run();
            int iCont = 0;
            while(true){
                Message msgMensa = hMiHanlder.obtainMessage(HILO_CHAFA, iCont++);
                hMiHanlder.sendMessage(msgMensa);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private Thread tHilo2 = new Thread(){
        @Override
        public void run() {
            super.run();
            int iCont = 0;
            while(true){
                Message msgMensa = hMiHanlder.obtainMessage(HILO_CHAFA2, iCont++);
                hMiHanlder.sendMessage(msgMensa);
                try {
                    Thread.sleep(2000);
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
        tHilo.start();
        tHilo2.start();
    }
}
