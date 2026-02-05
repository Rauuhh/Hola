package org.example.Practica1;

import java.time.LocalDate;
import java.util.Scanner;

public class Invitado {
    static Scanner entrada = new Scanner(System.in);
    private String nombre;
    private String profesion;
    private LocalDate fecha_visita;
    private int temporada;

    public Invitado(String nombre, String profesion, int temporada) {
        this.nombre = nombre;
        this.profesion = profesion;
        fecha_visita = LocalDate.now();
        this.temporada = temporada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public LocalDate getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(LocalDate fecha_visita) {
        System.out.println("Introduce el año que ira el invitado");
        int ano = entrada.nextInt();
        System.out.println("Introduce el mes que ira el invitado");
        int mes = entrada.nextInt();
        System.out.println("Introduce el dia que ira el invitado");
        int dia = entrada.nextInt();
        this.fecha_visita = LocalDate.of(ano,mes,dia);
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    @Override
    public String toString() {
        return "Invitado{" +
                "nombre='" + nombre + '\'' +
                ", profesion='" + profesion + '\'' +
                ", fecha_visita=" + fecha_visita +
                ", temporada=" + temporada +
                '}';
    }
}
