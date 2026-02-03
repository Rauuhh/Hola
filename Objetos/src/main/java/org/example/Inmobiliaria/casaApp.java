package org.example.Inmobiliaria;

public class casaApp {
    static void main() {

        Casa casa = new Casa("Calle Mayor 123");
        System.out.println(casa.getPropietario());
        casa.agregarHabitacion("Dormitorio",12);
        casa.agregarHabitacion("Cocina",21);
        casa.agregarHabitacion("Baño",17);

        casa.mostrarHabitaciones();

        System.out.println(casa.getHabitacionMasGrande());
    }
}
