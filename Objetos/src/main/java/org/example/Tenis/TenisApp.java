package org.example.Tenis;

public class TenisApp {
    static void main() {
            Jugador jugador1 = new Jugador("Alcaraz", 1);
            Jugador jugador2 = new Jugador("Sinner", 2);

            Partido partido1 = new Partido(jugador1,jugador2);
            partido1.insertarSet(6,3);
            partido1.insertarSet(6,4);
            partido1.insertarSet(5,7);
            partido1.insertarSet(6,2);
        System.out.println(partido1.getListaSet());
    }
}
