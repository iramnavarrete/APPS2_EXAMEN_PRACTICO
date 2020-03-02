package com.example.mostrar_imagen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ImageFragment extends Fragment {
    private View v;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        v = inflater.inflate(R.layout.fragment_image, container, false);

        int imageId = getArguments().getInt("image_id",R.drawable.t1);
        if(imageId != 0){
            ImageView imageView = v.findViewById(R.id.imageView);
            imageView.setImageResource(imageId);
        }

        return v;
    }
}
