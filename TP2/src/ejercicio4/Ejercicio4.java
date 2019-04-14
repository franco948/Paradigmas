package ejercicio4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio4 {

    /**
     * Dado un array de enteros, guarda en tres archivos diferentes
     * los numeros primos,
     */
    public static void guardarEnArchivo(int[] numeros) throws IOException {

        FileWriter primosWriter = new FileWriter("primos.txt");
        FileWriter divisores3MilWriter = new FileWriter("divisores_de_3000.txt");

        for(int i = 0; i < numeros.length; i++) {

            if(esPrimo(numeros[i])) {
                primosWriter.write(numeros[i] + System.lineSeparator());
            }

            if(3000 % numeros[i] == 0) {
                divisores3MilWriter.write(numeros[i] + System.lineSeparator());
            }
        }

        primosWriter.flush();
        primosWriter.close();

        divisores3MilWriter.flush();
        divisores3MilWriter.close();
    }

    public static boolean esPrimo(int numero) {

        numero = Math.abs(numero);

        int cantidadDivisores = 0;

        for(int i = 1; i <= numero; i++) {

            if(numero % i == 0) {
                cantidadDivisores++;

                if (cantidadDivisores > 2) {
                    return false;
                }
            }
        }

        return true;
    }
}
