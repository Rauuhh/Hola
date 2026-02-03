package org.example.Inmobiliaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Casa {
    static  Scanner entrada = new Scanner(System.in);
    private String direccion;
    private ArrayList<Habitacion> listaHabitaciones;
    private Propietario propietario;


    public Casa(String direccion) {
        this.direccion = direccion;
        listaHabitaciones = new ArrayList<>();
        setPropietario();
    }

    public void agregarHabitacion(String nombre, double metros) {
        for (Habitacion hab : listaHabitaciones){
            if (hab.getNombre().equals(nombre)){
                System.out.println("La habitacion "+ hab.getNombre() + " ya existe");
                return;
            }
        }
        Habitacion habitacion = new Habitacion(nombre,metros);
        listaHabitaciones.add(habitacion);
        System.out.println("Habitacion: " +  nombre + " creada");
    }

    public void mostrarHabitaciones() {
        System.out.println("Casa en " + direccion + " tiene las siguientes habitaciones:");
        for ( Habitacion hab : listaHabitaciones){
            System.out.println("- " + hab.getNombre() + " (" + hab.getMetros() + ") m2 y su propietario es " + propietario);
        }
    }

    public void eliminarHabitacion(String nombre){
        for ( Habitacion hab : listaHabitaciones){
            if (hab.getNombre().equals(nombre)){
                listaHabitaciones.remove(hab);
                System.out.println("La habitacion" + nombre + " borrada con exito");
            }else{
                System.out.println("La habitacion no existe");
            }
        }
    }

    public Habitacion getHabitacionMasGrande(){
        Habitacion mayor = listaHabitaciones.get(0);
        for (Habitacion hab : listaHabitaciones){
            if (mayor.getMetros() < hab.getMetros()){
                mayor = hab;
            }
        }
        return mayor;

    }

    public Habitacion habMasConsumo(){
        Habitacion mayor = listaHabitaciones.get(0);
        for (Habitacion hab : listaHabitaciones){
            if (hab.calcularConsumo() > mayor.calcularConsumo()){
                mayor = hab;
            }
        }
        return mayor;

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public ArrayList<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario() {
        System.out.println("Nombre propietario");
        String nombre = entrada.nextLine();
        System.out.println("Edad propietario");
        int edad = entrada.nextInt();
        this.propietario = new Propietario(nombre,edad);
    }

    @Override
    public String toString() {
        return "Casa{" +
                "direccion='" + direccion + '\'' +
                '}';
    }
}
