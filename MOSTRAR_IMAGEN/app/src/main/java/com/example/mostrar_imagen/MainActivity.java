package com.example.mostrar_imagen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Integer> imagesId;
    private int orientation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imagesId = new ArrayList();
        addImagesId();

        // Se obtiene la orientacion actual del celular
        orientation = getResources().getConfiguration().orientation;

        SeekBar seekBar = findViewById(R.id.imageProgress);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress > 0){
                    changeImages(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        changeImages(1);
    }

    private void addImagesId(){
        imagesId.add(R.drawable.t1);
        imagesId.add(R.drawable.t2);
        imagesId.add(R.drawable.t3);
        imagesId.add(R.drawable.t4);
        imagesId.add(R.drawable.t5);
        imagesId.add(R.drawable.t6);
        imagesId.add(R.drawable.t7);
        imagesId.add(R.drawable.t8);
        imagesId.add(R.drawable.t9);
        imagesId.add(R.drawable.t10);
    }

    private void changeImages(int image_index){
        if(orientation == Configuration.ORIENTATION_PORTRAIT){
            /**
             * Cuando esta en portrait solo se muestra una imagen
             */

            ImageFragment fragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("image_id",imagesId.get(image_index - 1));
            fragment.setArguments(bundle);

            changeFragment(fragment,R.id.imgFragment1);
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            /**
             * Cuando esta en landscape se pueden mostrar hasta 3 imagenes
             */

            // La imagen de en medio siempre se muestra. Es el index del seek bar
            ImageFragment fragment = new ImageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("image_id",imagesId.get(image_index - 1));
            fragment.setArguments(bundle);

            changeFragment(fragment,R.id.imgFragment2);

            // Si es la primera imagen. No se debe mostrar la imagen de la izquierda
            if(image_index >= 2){
                findViewById(R.id.imgFragment1).setVisibility(View.VISIBLE);

                ImageFragment fragment1 = new ImageFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("image_id",imagesId.get(image_index - 2));
                fragment1.setArguments(bundle1);

                changeFragment(fragment1,R.id.imgFragment1);
            } else {
                findViewById(R.id.imgFragment1).setVisibility(View.INVISIBLE);
            }

            // Si es la ultima imagen, no se debe mostrar la imagen de la derecha
            if(image_index < 10){
                findViewById(R.id.imgFragment3).setVisibility(View.VISIBLE);

                ImageFragment fragment3 = new ImageFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putInt("image_id",imagesId.get(image_index));
                fragment3.setArguments(bundle3);

                changeFragment(fragment3,R.id.imgFragment3);
            } else {
                findViewById(R.id.imgFragment3).setVisibility(View.INVISIBLE);
            }
        }
    }


    // Ayuda a hacer el cambio de los fragmentos
    private void changeFragment(Fragment fragment, int replace){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        ft.replace(replace,fragment);
        ft.commit();
    }
}
