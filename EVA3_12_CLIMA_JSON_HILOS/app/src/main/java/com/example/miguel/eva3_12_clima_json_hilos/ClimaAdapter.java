package com.example.miguel.eva3_12_clima_json_hilos;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ClimaAdapter extends ArrayAdapter <Clima>{

    private Context cApp;
    private int iLayout;
    private List<Clima> acDatos;

    public ClimaAdapter(Context context, int resource, List<Clima> objects) {
        super(context, resource, objects);
        cApp = context;
        iLayout = resource;
        acDatos = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgClima;
        TextView txtCiudad, txtClima, txtDesc, txtTemp;

        if(convertView == null){ //NO EXISTE LA FILA, HAY QUE CREARLA
            LayoutInflater layoutInflater = ((Activity)cApp).getLayoutInflater();
            convertView = layoutInflater.inflate(iLayout, parent, false);
        }

        imgClima = convertView.findViewById(R.id.imgClima3);
        txtCiudad = convertView.findViewById(R.id.txtCiudad3);
        txtDesc = convertView.findViewById(R.id.txtDesc3);
        txtTemp = convertView.findViewById(R.id.txtTemp3);
        txtClima = convertView.findViewById(R.id.txtClima3);

        Clima cClima = acDatos.get(position);
        imgClima.setImageResource(cClima.getImagen_clima());
        txtCiudad.setText(cClima.getCiudad());
        txtDesc.setText(cClima.getDesc_clima());
        txtTemp.setText(cClima.getTemp()+" °F");
        txtClima.setText(cClima.getClima());

        return convertView;
    }
}
