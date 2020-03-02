package com.example.examen_areas_figuras;

import android.widget.ImageView;

public class Figura {
    int imagen;
    String nombre;
    double lado1;
    double lado2;
    int position;



    public Figura(int imagen, String nombre) {
        this.imagen = imagen;
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
