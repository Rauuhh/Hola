package org.example.Tenis;

import java.util.ArrayList;

public class Partido {

    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Set> listaSet;

    public Partido(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        listaSet = new ArrayList<>();
        jugador1.setRival(jugador2);
        jugador2.setRival(jugador1);
    }

    public void insertarSet(int puntosJ1, int puntosJ2) {
        Set nuevoSet = new Set(puntosJ1, puntosJ2);

        listaSet.add(nuevoSet);
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public ArrayList<Set> getListaSet() {
        return listaSet;
    }

    public void setListaSet(ArrayList<Set> listaSet) {
        this.listaSet = listaSet;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "jugador1=" + jugador1 +
                ", jugador2=" + jugador2 +
                ", listaSet=" + listaSet +
                '}';
    }
}
