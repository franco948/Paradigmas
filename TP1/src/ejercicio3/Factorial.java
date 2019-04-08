package ejercicio3;

import java.lang.Math;

public class Factorial {

    private int numero;

    public Factorial(int numero) {
        this.numero = Math.abs(numero);
    }

    public int getValor() {
        if(numero == 0) return 1;

        int factorial = 1;

        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
