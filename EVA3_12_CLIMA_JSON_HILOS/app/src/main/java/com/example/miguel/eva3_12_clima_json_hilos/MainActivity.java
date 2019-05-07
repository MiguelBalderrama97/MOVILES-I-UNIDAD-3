package com.example.miguel.eva3_12_clima_json_hilos;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Clima> lstCiudades = new ArrayList<>();

    private ListView llCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llCiudades = findViewById(R.id.lstVwCiudades);

        ConexionClima ccClimaCiudad = new ConexionClima();
        ccClimaCiudad.execute();
    }

    class ConexionClima extends AsyncTask<Void, Void, String>{

//        CONEXION, RECIBIR LOS DATOS COMO CADENA EN FORMATO JSON
        @Override
        protected String doInBackground(Void... voids) {
            String sUrl = "https://samples.openweathermap.org/data/2.5/find?lat=55.5&lon=37.5&cnt=10&appid=b6907d289e10d714a6e88b30761fae22";
            String sResu = "";
//            HACER LA CONEXION
            try {
                URL url = new URL(sUrl);
                HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();
                if(httpCon.getResponseCode() == HttpURLConnection.HTTP_OK){
//                    BUFFERED READER
//                    INPUTSTREAMREADER
                    BufferedReader brDatosJSON = new BufferedReader(
                            new InputStreamReader(
                                    httpCon.getInputStream()
                            )
                    );
                    sResu = brDatosJSON.readLine();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResu;
        }

//        LEER ESA CADENA Y LLENAR LA LISTA
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(!s.equals("")){ //RECIBIMOS UN DATO
                Toast.makeText(MainActivity.this, s+"", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
