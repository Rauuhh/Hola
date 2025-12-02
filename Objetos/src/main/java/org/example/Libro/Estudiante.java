package org.example.Libro;

import java.util.ArrayList;

public class Estudiante {

    private static int contadorEstudiantes;
    private static String CORREO_FORMAT = ("^[A-Za-z0-9+_.-]+@alu.edu.gva.es$");

    private String nombre;
    private String curso;
    private int nia;
    private String email;
    private ArrayList<Libro> listalibro;

    public Estudiante(String nombre, String curso, String email) {
        this.nombre = nombre;
        this.curso = curso;
        this.email = email;
        nia = ++contadorEstudiantes;
        listalibro = new ArrayList<>();
    }

    public Estudiante(String nombre) {
        this(nombre," "," ");
    }

    public String getNombre() {
        return nombre;
    }

    public static int obtenerTotalEstudiantes(){
        return contadorEstudiantes;
    }

    public static boolean validarCorreo(String correo){
        if (correo.matches(CORREO_FORMAT)){
            return true;
        }
        return false;
    }

    public void insertarLibro(Libro libro){
        listalibro.add(libro);
    }


    public void borrarLibro(Libro libro){
        listalibro.remove(libro);
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNia() {
        return nia;
    }

    private void setNia(int nia) {
        this.nia = nia;
    }
    public ArrayList<Libro> getListaLibro() {
        return listalibro;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                ", nia=" + nia +
                ", email='" + email + '\'' +
                '}';
    }
}