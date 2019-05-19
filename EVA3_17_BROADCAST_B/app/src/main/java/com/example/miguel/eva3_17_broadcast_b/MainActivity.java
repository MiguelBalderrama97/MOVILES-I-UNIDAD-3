package com.example.miguel.eva3_17_broadcast_b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtDatos;

    private BroadcastReceiver brReceptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDatos = findViewById(R.id.txtDatos);
        brReceptor = new MiBroadcast();

        IntentFilter ifMiServicio = new IntentFilter("MI_SERVICIO");
        registerReceiver(brReceptor, ifMiServicio);
    }

    class MiBroadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
//                AQUI INTERPRETAMOS LOS DATOS
//                PONER LOS DATOS EN EL TEXTVIEW
            String sCade = intent.getStringExtra("MENSAJE");
            txtDatos.append(sCade+" ");
        }
    }
}
