package org.example.Libro;

public class LibroApp {
    static void main() {



        Estudiante jorge = new Estudiante("jorge");
        Editorial editorial = new Editorial("Satillana", "España");
        Libro divina_comedia = new Libro("Hola","Adios",editorial);
        System.out.println(Libro.getLibrosDisponibles());


        Prestamo p1 = divina_comedia.prestar(jorge);

        System.out.println("Fecha prestado " +  p1.getFecha());

        System.out.println(jorge.getListaLibro());



        divina_comedia.devolver();
        System.out.println(divina_comedia);

        System.out.println("Libros disponibles " +  Libro.getLibrosDisponibles());
        System.out.println("Libros creados " + Libro.getTotalLibros());


    }
}