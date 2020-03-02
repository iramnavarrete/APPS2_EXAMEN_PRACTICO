package com.example.eva1_examentab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button ares, falcon, shuttle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ares = findViewById(R.id.buttonAres);
        ares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ares();
            }
        });
        falcon = findViewById(R.id.buttonFalcon);
        falcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { falcon();
            }
        });
        shuttle = findViewById(R.id.buttonShuttle);
        shuttle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shuttle();
            }
        });




    }
    public void shuttle(){androidx.fragment.app.FragmentTransaction fc = getSupportFragmentManager().beginTransaction();
        fc.setCustomAnimations(android.R.anim.slide_in_left ,android.R.anim.slide_out_right);
        Shuttle shut =  new Shuttle();
        fc.replace(R.id.fragment,shut);
        fc.addToBackStack("holas");
        fc.commit();
    }



    public void ares(){
        androidx.fragment.app.FragmentTransaction fc = getSupportFragmentManager().beginTransaction();
        fc.setCustomAnimations(android.R.anim.slide_in_left ,android.R.anim.slide_out_right);
        AresV ares =  new AresV();
        fc.replace(R.id.fragment,ares);
        fc.addToBackStack("holas");
        fc.commit();
    }

    public void falcon(){
        androidx.fragment.app.FragmentTransaction fc = getSupportFragmentManager().beginTransaction();
        fc.setCustomAnimations(android.R.anim.slide_in_left ,android.R.anim.slide_out_right);
        Falcon flcon =  new Falcon();
        fc.replace(R.id.fragment,flcon);
        fc.addToBackStack("holas");
        fc.commit();
    }




}
