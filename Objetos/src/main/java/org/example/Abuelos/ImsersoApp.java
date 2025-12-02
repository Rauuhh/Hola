package org.example.Abuelos;

public class ImsersoApp {
    static void main() {
        Abuelo manolo = new Abuelo("Manolo",89);
        Abuelo pepe = new Abuelo("Pepe",67);
        Abuelo marisa = new Abuelo("Marisa",75);
        Abuelo euge = new Abuelo("Euge",68);

        Autobus alsa = new Autobus("1234KKK", "Benidorm");

        alsa.insertarAbuelo(pepe);
        alsa.insertarAbuelo(manolo);
        alsa.insertarAbuelo(marisa);
        alsa.insertarAbuelo(euge);


        System.out.println(alsa.getListaAbuelos());

        alsa.borrarAbuelo(euge);
        System.out.println(alsa.getListaAbuelos());
        System.out.println();
        alsa.mostrarPasajeros();
        alsa.mostrarMayores(76);

    }
}
