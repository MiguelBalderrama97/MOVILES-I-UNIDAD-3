package com.example.miguel.eva3_8_ejemplo_hilos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ImageView imgZelda;
    private Bitmap bImagen;

    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
//            AQUI VAMOS A MOSTRAR LA IMAGEN
            imgZelda.setImageBitmap(bImagen);
        }
    };

    private Thread thread = new Thread() {
        @Override
        public void run() {
            super.run();
//            AQUI VAMOS A CARGAR LA IMAGEN
            bImagen = cargarImagen("https://www.ionlitio.com/images/2017/04/zelda-botw-portada.jpg");
            handler.post(runnable);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgZelda = findViewById(R.id.imgZelda);

        thread.start();
    }

    private Bitmap cargarImagen(String url) {
        try {
            InputStream isImagen = null;
            isImagen = (InputStream) new URL(url).getContent();
            Bitmap bBitMap = BitmapFactory.decodeStream(isImagen);
            return bBitMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
