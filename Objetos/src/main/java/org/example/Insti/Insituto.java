package org.example.Insti;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Objects;

@ToString
@Getter
public class Insituto {

    private final String nombre;
    private String poblacion;

    private ArrayList<Estudiante> listaEstudiantes;
    private ArrayList<Curso> listaCursos;

    public Insituto(String nombre, String poblacion) {
        this.nombre = Objects.requireNonNullElse(nombre, "IES");
        this.poblacion = poblacion;
        this.listaEstudiantes = new ArrayList<>();
        this.listaCursos = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            listaEstudiantes.add(estudiante);
        }
    }

    public void agregarCurso(Curso curso) {
        if (curso == null) {
            return;
        }

        for (Curso curso1 : listaCursos) {
            if (curso1.getNombre().equals(curso.getNombre()) && curso1.getHoras() == curso.getHoras()) {
                return; // curso duplicado
            }
        }

        listaCursos.add(curso);
    }
}
