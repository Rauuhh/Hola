package org.example.Libro;

import java.util.ArrayList;

public class Editorial {
    private String nombre;
    private String pais;
    private ArrayList<Libro> listalibros;

    public Editorial(){

    }

    public Editorial(String nombre, String pais){
        this.nombre = nombre;
        this.pais = pais;
        listalibros = new ArrayList<>();
    }


    public void anyadirLibro(Libro libro){
        listalibros.add(libro);
    }

    public void borrarLibro(Libro libro){
        listalibros.remove(libro);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public ArrayList<Libro> getListalibros() {
        return listalibros;
    }

    public void setListalibros(ArrayList<Libro> listalibros) {
        this.listalibros = listalibros;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", listaLibros='" + listalibros + '\'' +
                '}';
    }
}
