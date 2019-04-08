package ejercicio1;

import java.lang.String;

public class Recta {

    private int m;
    private int b;

    public Recta(int m, int b) {
        this.m = m;
        this.b = b;
    }

    public boolean verificarPunto(int x, int y) {
        int ecuacion = m * x + b;

        return (y == ecuacion);
    }
}
