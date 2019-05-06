package com.example.miguel.eva3_10_asynk_task;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDatos = findViewById(R.id.txtDatos);

        MiClase obj = new MiClase();
        obj.execute(2,3,3);
    }

    class MiClase extends AsyncTask<Integer,String,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtDatos.setText("INICIANDO TAREA ASINCRONA!!\n");
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            txtDatos.setText("\nTERMINANDO TAREA ASINCRONA");
        }

//        AQUI SE RE
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            if(values.length > 0){
                txtDatos.append(values[0]);
            }
        }

//        EN TODOS LOS METODOS SE PUEDEN INTERACTUAR CON LA UI MENOS AQUI
//        EQUIVALENTE AL METODO RUN
        @Override
        protected Void doInBackground(Integer... integers) {
            int i = 0;
            while(true){
                try {
                    Thread.sleep(500);
                    publishProgress("Hola " + (i++) + "\n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
