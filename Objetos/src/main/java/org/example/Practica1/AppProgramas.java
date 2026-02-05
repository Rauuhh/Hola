package org.example.Practica1;

public class AppProgramas {
    static void main() {
        // creamos una cadena de tv
        Cadena antena3 = new Cadena("Antena 3");
        System.out.println(antena3);
        //creamos un programa
        Programa el_hormiguero = new Programa("El Hormiguero",antena3,"Director1");
        System.out.println(el_hormiguero);
        antena3.anadirPrograma(el_hormiguero);
        System.out.println(antena3);
        //insertamos empleados en el programa
        el_hormiguero.insertarEmpleado("Pablo Motos","presentador");
        System.out.println(el_hormiguero);
        //ver empleados del programa
        System.out.println(el_hormiguero.getListaEmpleado());
        //insertamos invitados en el programa
        el_hormiguero.insertarInvitado("Aitana","cantante",1);
        //ver invitados del programa
        System.out.println(el_hormiguero.getListaInvitado());
        System.out.println(el_hormiguero);
        System.out.println(antena3);

    }
}
