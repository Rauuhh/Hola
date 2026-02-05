package org.example.Practica1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Programa {

    private static int TEMPORADA = 0;

    private String nombre;
    private Cadena cadena;
    private int temporadas;
    private ArrayList<Empleado> listaEmpleado;
    private ArrayList<Invitado> listaInvitado;
    private Empleado director;

    public Programa(String nombre, Cadena cadena, String nDirector) {
        this.nombre = nombre;
        this.cadena = cadena;
        this.temporadas = TEMPORADA;
        listaEmpleado = new ArrayList<>();
        listaInvitado = new ArrayList<>();
        this.director = new Empleado(nDirector,"Director", null);
    }

    public void insertarEmpleado(String nombre, String empleado){
        listaEmpleado.add(new Empleado(nombre,empleado,director));
    }
    public void insertarInvitado(String nombre, String empleado, int temporadas){
        listaInvitado.add(new Invitado(nombre,empleado,temporadas));
    }

    public void invitadosTemporada(int temporadas){
        for (Invitado inv : listaInvitado){
            if (inv.getTemporada() == temporadas){
                System.out.println(inv.getNombre() + inv.getProfesion());
            }
        }
    }

    public int vecesInvitado(String nombre) {
        int contador = 0;

        for (Invitado invitado : listaInvitado) {
            if (invitado.getNombre().equalsIgnoreCase(nombre)) {
                contador++;
            }
        }
        return contador;
    }

    public void rastrearInvitado(String nombre) {
        int veces = vecesInvitado(nombre);

        if (veces == 0) {
            System.out.println(nombre + " no ha acudido nunca al programa.");
            return;
        }

        System.out.println(nombre + " ha acudido " + veces + " veces al programa");
        for (Invitado invitado : listaInvitado) {
            if (invitado.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Fecha: " + invitado.getFecha_visita() + " Temporada: " + invitado.getTemporada());
            }
        }
    }
    public boolean buscarInvitado(String nombre) {
        for (Invitado invitado : listaInvitado) {
            if (invitado.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public void invitadoAntes(String nombre, Programa otro) {

        if (!buscarInvitado(nombre) || !otro.buscarInvitado(nombre)) {
            System.out.println(nombre + " no ha estado en ambos programas.");
            return;
        }

        LocalDate fecha1 = null;
        LocalDate fecha2 = null;

        for (Invitado invitado : listaInvitado) {
            if (invitado.getNombre().equalsIgnoreCase(nombre)) {
                fecha1 = invitado.getFecha_visita();
                break;
            }
        }

        for (Invitado invitado : otro.getListaInvitado()) {
            if (invitado.getNombre().equalsIgnoreCase(nombre)) {
                fecha2 = invitado.getFecha_visita();
                break;
            }
        }

        if (fecha1.isBefore(fecha2)) {
            System.out.println(nombre + " ha estado antes en: " + getNombre());
        } else {
            System.out.println(nombre + " ha estado antes en: " + otro.getNombre());
        }
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cadena getCadena() {
        return cadena;
    }

    public void setCadena(Cadena cadena) {
        this.cadena = cadena;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
    public ArrayList<Invitado> getListaInvitado() {
        return listaInvitado;
    }

    public ArrayList<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public Empleado getDirecto() {
        return director;
    }

    public void setDirecto(Empleado director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Programa{" +
                "nombre='" + nombre + '\'' +
                ", cadena=" + cadena.getNombre() +
                ", temporadas=" + temporadas +
                ", listaEmpleado=" + listaEmpleado +
                ", listaInvitado=" + listaInvitado +
                ", director=" + director +
                '}';
    }
}
