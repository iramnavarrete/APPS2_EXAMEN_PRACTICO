package com.example.examen_areas_figuras;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFigura extends Fragment{


    ListView listaFiguras;

    MainActivity main;

    AdapterView.OnItemClickListener miclick;

    Figura[] figuras = {
            new Figura(R.drawable.circle, "Círculo"),
            new Figura(R.drawable.eclipse, "Elípse"),
            new Figura(R.drawable.heptagon, "Heptágono"),
            new Figura(R.drawable.hexagon, "Hexágono"),
            new Figura(R.drawable.pentagono, "Pentágono"),
            new Figura(R.drawable.rectangle, "Rectángulo"),
            new Figura(R.drawable.rhomboid, "Romboide"),
            new Figura(R.drawable.rhombus, "Rombo"),
            new Figura(R.drawable.square, "Cuadrado"),
            new Figura(R.drawable.traingle, "Tríangulo")
    };

    public void onClickItem(AdapterView.OnItemClickListener click){
        miclick = click;
    }

    public FragmentFigura() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.fragment_fragment_figura, container, false);

        listaFiguras = ll.findViewById(R.id.listaFiguras);
        listaFiguras.setAdapter(new FiguraAdapter(getContext(), R.layout.layout_figura, figuras));
        listaFiguras.setOnItemClickListener(miclick);
        return ll;
    }

    public Figura[] getFiguras() {
        return figuras;
    }


}
