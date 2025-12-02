package org.example.Abuelos;

import java.util.ArrayList;

public class Autobus {

    private String matricula;
    private String destino;
    private ArrayList<Abuelo> listaAbuelos;

    public Autobus(String matricula, String destino) {
        this.matricula = matricula;
        this.destino = destino;
        listaAbuelos = new ArrayList<>();
    }


    public void insertarAbuelo(Abuelo abuelo){
        listaAbuelos.add(abuelo);
    }

    public void borrarAbuelo(Abuelo abuelo){
        listaAbuelos.remove(abuelo);
    }

    public void mostrarPasajeros(){
        System.out.println("Abuelos del autobus con matricula: " + matricula);
        for (Abuelo abu : listaAbuelos){
            System.out.println(abu.getNombre() + " , y tiene " + abu.getEdad() + " años de edad");
        }
    }

    public void mostrarMayores(int edad){
        System.out.println("Abuelos mayores de " + edad);
        for (Abuelo abu : listaAbuelos){
            if (abu.getEdad() > edad) {
                System.out.println(abu.getNombre() + " , y tiene " + abu.getEdad() + " años de edad");
            }
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public ArrayList<Abuelo> getListaAbuelos() {
        return listaAbuelos;
    }

    public void setListaAbuelos(ArrayList<Abuelo> listaAbuelos) {
        this.listaAbuelos = listaAbuelos;
    }

    @Override
    public String toString() {
        return "Autobus{" +
                "matricula='" + matricula + '\'' +
                ", destino='" + destino + '\'' +
                ", listaAbuelos=" + listaAbuelos +
                '}';
    }
}
