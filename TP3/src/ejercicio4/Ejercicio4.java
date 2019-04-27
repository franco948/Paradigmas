package ejercicio4;

import ejercicio2.Ejercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Ejercicio4 {

    public static void main(String[] args) {

    }

    public static void ahorcado(String path) {

    }

    public static String elegirPalabra(List<String> palabras) {
        return palabras.get(generarRandom(0, palabras.size() - 1));
    }

    public static List<String> leerPalabras(String path) throws FileNotFoundException, IOException {

        List<String> palabras = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line = reader.readLine();

        while (line != null) {

            //if ( Ejercicio2.match("[a-z\\sA-Z]+", line) ){
            if ( Ejercicio2.match("[a-zA-Z]+", line) ){
                palabras.add(line);
            }

            line = reader.readLine();
        }

        reader.close();

        return palabras;
    }

    public static int generarRandom(int lowerBound, int upperBound) {
        int resultado = 0;

        resultado = (int)( Math.random() * (upperBound - lowerBound) + lowerBound );

        return resultado;
    }
}
