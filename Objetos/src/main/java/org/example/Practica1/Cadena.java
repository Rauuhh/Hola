package org.example.Practica1;

import java.util.ArrayList;
import java.util.Collection;

public class Cadena {
    private String nombre;
    private ArrayList<Programa> listaProgramas;


    public Cadena(String nombre) {
        this.nombre = nombre;
        listaProgramas = new ArrayList<>();
    }

    public void anadirPrograma (Programa nombre){
        listaProgramas.add(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Programa> getListaProgramas() {
        return listaProgramas;
    }

    @Override
    public String toString() {
        return "Cadena{" +
                "nombre='" + nombre + '\'' +
                ", listaProgramas=" + listaProgramas +
                '}';
    }
}
