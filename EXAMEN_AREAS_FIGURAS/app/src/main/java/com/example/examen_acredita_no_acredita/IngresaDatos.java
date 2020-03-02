package com.example.examen_areas_figuras;


import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class IngresaDatos extends Fragment {

    ImageView image;
    TextView textView1, textView2, nombre;
    EditText editText1, editText2;
    Figura figura;
    Button btn;
    //int position;

    public IngresaDatos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_ingresa_datos, container, false);
        image=linearLayout.findViewById(R.id.imageView2);
        nombre=linearLayout.findViewById(R.id.nombre);
        textView1=linearLayout.findViewById(R.id.textView);
        textView2=linearLayout.findViewById(R.id.textView2);
        editText1=linearLayout.findViewById(R.id.editText);
        editText2=linearLayout.findViewById(R.id.editText2);
        btn=linearLayout.findViewById(R.id.button);

        image.setImageResource(figura.getImagen());
        nombre.setText(figura.getNombre());

        switch ((figura.getNombre())){
            case "Círculo":
                textView1.setText("Radio");
                textView2.setVisibility(View.INVISIBLE);
                editText2.setVisibility(View.INVISIBLE);
                break;
            case "Elípse":
                textView1.setText("Lado a");
                textView2.setText("Lado b");
                break;
            case "Heptágono":
                textView1.setText("Lado L");
                textView2.setText("Apotema");
                break;
            case "Hexágono":
                textView1.setText("Lado");
                textView2.setText("Apotema");
                break;
            case "Pentágono":
                textView1.setText("Lado");
                textView2.setText("Apotema");
                break;
            case "Rectángulo":
                textView1.setText("Base");
                textView2.setText("Altura");
                break;
            case "Romboide":
                textView1.setText("Base");
                textView2.setText("Altura");
                break;
            case "Rombo":
                textView1.setText("Lado d1");
                textView2.setText("Lado d2");
                break;
            case "Cuadrado":
                textView1.setText("Lado L");
                textView2.setVisibility(View.INVISIBLE);
                editText2.setVisibility(View.INVISIBLE);
                break;
            case "Tríangulo":
                textView1.setText("Base");
                textView2.setText("Altura");
                break;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lado1 = Double.valueOf(editText1.getText().toString());
                double lado2;
                double res=0;

                switch ((figura.getNombre())){
                    case "Círculo":
                        res = Math.PI*lado1*lado1;
                        break;
                    case "Cuadrado":
                        res = lado1*lado1;
                        break;
                    case "Elípse":
                        lado2 = Double.valueOf(editText2.getText().toString());
                        res = Math.PI*lado1*lado2;
                        break;
                    case "Heptágono":
                        lado2 = Double.valueOf(editText2.getText().toString());
                        res = (lado1*7*lado2)/2;
                        break;
                    case "Hexágono":
                        lado2 = Double.valueOf(editText2.getText().toString());
                        res = (lado1*6*lado2)/2;
                        break;
                    case "Pentágono":
                        lado2 = Double.valueOf(editText2.getText().toString());
                        res = (lado1*5*lado2)/2;
                        break;
                    case "Rectángulo":
                        lado2 = Double.valueOf(editText2.getText().toString());
                        res = lado1*lado2;
                        break;
                    case "Romboide":
                        lado2 = Double.valueOf(editText2.getText().toString());
                        res = lado1*lado2;
                        break;
                    case "Rombo":
                        lado2 = Double.valueOf(editText2.getText().toString());
                        res = (lado1*lado2)/2;
                        break;
                    case "Tríangulo":
                        lado2 = Double.valueOf(editText2.getText().toString());
                        res = (lado1*lado2)/2;
                        break;
                }
                Toast.makeText(getContext(), "Área="+res,Toast.LENGTH_LONG).show();
            }


        });

        return linearLayout;
    }

    public void onMessageFromMain(Figura figura){
        this.figura=figura;
    }
}
