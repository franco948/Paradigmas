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

        int sumaDePares = 0, cantidadPares = 0;
        int sumaDeImpares = 0, cantidadImpares = 0;

        FileWriter primosWriter = new FileWriter("primos.txt");
        FileWriter divisores3MilWriter = new FileWriter("divisores_de_3000.txt");
        FileWriter promediosWriter = new FileWriter("promedios.txt");

        for(int i = 0; i < numeros.length; i++) {

            if (esPrimo(numeros[i])) {
                primosWriter.write(numeros[i] + System.lineSeparator());
            }

            if (3000 % numeros[i] == 0) {
                divisores3MilWriter.write(numeros[i] + System.lineSeparator());
            }

            if (numeros[i] % 2 == 0) {
                sumaDePares += numeros[i];
                cantidadPares++;
            }
            else {
                sumaDeImpares += numeros[i];
                cantidadImpares++;
            }
        }

        promediosWriter.write((sumaDePares / cantidadPares)  + System.lineSeparator());
        promediosWriter.write((sumaDeImpares / cantidadImpares)  + System.lineSeparator());

        primosWriter.flush();
        primosWriter.close();

        divisores3MilWriter.flush();
        divisores3MilWriter.close();

        promediosWriter.flush();
        promediosWriter.close();
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
