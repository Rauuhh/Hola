package org.example.Tenis;

public class Set {
    private int puntosJ1;
    private int puntosJ2;

    public Set(int puntosJ1, int puntosJ2) {

        if (!puntuacionValida(puntosJ1, puntosJ2)) {
            System.out.println("Puntuacion no valida");
            
        }else {
            this.puntosJ1 = puntosJ1;
            this.puntosJ2 = puntosJ2;
        }
    }


    private boolean puntuacionValida(int puntos1, int puntos2) {

        if (puntos1 < 0 || puntos2 < 0 || puntos1 > 7 || puntos2 > 7) {
            return false;
        }
        else if ((puntos1 == 6 && puntos2 <= 4) || (puntos2 == 6 && puntos1 <= 4)) {
            return true;
        }

        // Tie-break
        else if ((puntos1 == 7 && (puntos2 == 5 || puntos2 == 6)) || (puntos2 == 7 && (puntos1 == 5 || puntos1 == 6))) {
            return true;
        }

        return false;
    }


    public int getPuntosJ1() {
        return puntosJ1;
    }

    public void setPuntosJ1(int puntosJ1) {
        this.puntosJ1 = puntosJ1;
    }

    public int getPuntosJ2() {
        return puntosJ2;
    }

    public void setPuntosJ2(int puntosJ2) {
        this.puntosJ2 = puntosJ2;
    }

    @Override
    public String toString() {
        return "Set{" +
                "puntosJ1=" + puntosJ1 +
                ", puntosJ2=" + puntosJ2 +
                '}';
    }
}
