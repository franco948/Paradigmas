package ejercicio6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio6 {

    public static void transponer(String pathEntrada, String pathSalida) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(pathEntrada));



        reader.close();
    }
}
