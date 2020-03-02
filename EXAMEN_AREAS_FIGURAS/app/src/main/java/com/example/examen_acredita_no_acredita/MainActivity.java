package com.example.examen_areas_figuras;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        final FragmentFigura fragmentFigura = new FragmentFigura();
        //ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out);
        fragmentFigura.onClickItem(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), fragmentFigura.getFiguras()[position].getNombre(), Toast.LENGTH_SHORT).show();
                Log.wtf("AQUI", "HOLA PERRO");
                FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                ft2.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                IngresaDatos ingresaDatos = new IngresaDatos();
                ingresaDatos.onMessageFromMain(fragmentFigura.getFiguras()[position]);
                ft2.replace(R.id.frameLayout, ingresaDatos);
                ft2.addToBackStack("ho");
                ft2.commit();
            }
        });

        ft.replace(R.id.frameLayout,fragmentFigura);
        //ft.addToBackStack("holas");
        ft.commit();


    }

}
