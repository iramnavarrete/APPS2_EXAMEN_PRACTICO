package com.example.examen_areas_figuras;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FiguraAdapter extends ArrayAdapter<Figura> {

    Context context;
    int resource;
    Figura[] figuras;

    public FiguraAdapter(Context context, int resource, Figura[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.figuras = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView txtCiudad, txtTemp, textView;

        if(convertView == null){
            //Crear nuestro layout que representa una fila en la lista
            //INFLATER

            LayoutInflater lInflater = ((Activity) context).getLayoutInflater();
            convertView = lInflater.inflate(resource, parent, false);
        }

        imageView = convertView.findViewById(R.id.imageView);
        txtCiudad = convertView.findViewById(R.id.txtFigura);

        imageView.setImageResource(figuras[position].getImagen());
        txtCiudad.setText(figuras[position].getNombre());

        return convertView;
    }
}
