package com.example.miguel.eva3_14_broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnStart, btnStop;
    private TextView txtDatos;

    private Intent inMiServicio;

    private BroadcastReceiver brReceptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        txtDatos = findViewById(R.id.txtResu);

        inMiServicio = new Intent(this, MiServicio.class);
        brReceptor = new MiBroadcast();

//        DECIRLE AL BROADCAST QUE SERVICIO DEBE ESCUCHAR
        IntentFilter ifMiServicio = new IntentFilter("MI_SERVICIO");
        registerReceiver(brReceptor, ifMiServicio);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(inMiServicio);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(inMiServicio);
            }
        });
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
