package ejercicio2;

import java.lang.Math;

public class DigitoMasAlto {

    public int encontrarDigitoMasAlto(int numero) {
        int aux = Math.abs(numero);
        int digito = 0;

        while (aux % 10 != 0 || aux / 10 != 0) {

            if (aux % 10 > digito) {
                digito = aux % 10;
            }

            aux /= 10;
        }

        return digito;
    }
}
