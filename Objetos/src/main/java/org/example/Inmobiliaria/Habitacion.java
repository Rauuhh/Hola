package org.example.Inmobiliaria;

import java.util.ArrayList;

public class Habitacion {
    private  String nombre;
    private double metros;
    private ArrayList<Electrodomestico> listaElectrodomestico;


    public Habitacion(String nombre, double metros) {
        this.nombre = nombre;
        this.metros = metros;
        listaElectrodomestico = new ArrayList<>();
    }


    public void agregarElectrodomestico(String nombre, int vatios) {
        Electrodomestico elec = new Electrodomestico(nombre,vatios);
        listaElectrodomestico.add(elec);
    }


    public void mostrarElectrodomesticos() {
        for ( Electrodomestico elec : listaElectrodomestico){
            System.out.println("- " + elec.getNombre() + " (" + elec.getConsumo() + ") KwH");
        }
    }

    public double calcularConsumo(){
        double suma = 0;
        for (Electrodomestico elec: listaElectrodomestico){
            suma += elec.getConsumo();
        }
        return suma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMetros() {
        return metros;
    }

    public void setMetros(double metros) {
        this.metros = metros;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "nombre='" + nombre + '\'' +
                ", metros=" + metros +
                '}';
    }
}
