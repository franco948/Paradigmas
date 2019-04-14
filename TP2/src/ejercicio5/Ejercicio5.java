package ejercicio5;

import ejercicio4.Ejercicio4;

public class Ejercicio5 {

    public static int[] obtenerPrimosGemelos(int m) {

        int p = Math.abs(m), q = Math.abs(m) + 2;

        while(!Ejercicio4.esPrimo(p) || !Ejercicio4.esPrimo(q)) {
            p++; q++;
        }

        return new int[] {p, q};
    }
}
