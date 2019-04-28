package ejercicio4;

import ejercicio2.Ejercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ejercicio4 {

    private static int intentos;

    public static void main(String[] args) throws IOException {

        boolean gano = false;

        Scanner scanner = new Scanner(System.in);

        intentos = 0;

        //List<String> palabras = leerPalabras("F:\\dev\\Paradigmas\\TP3\\ahorcado.txt");
        List<String> palabras = leerPalabras("TP3\\ahorcado.txt");

        String palabraElegida = elegirPalabra(palabras);

        String[] letras = palabraElegida.split("");

        Set<String> restantes = new HashSet<>();
        Set<String> adivinadas = new HashSet<>();

        for (int i = 0; i < palabraElegida.length(); i++) {
            restantes.add(letras[i]);
        }

        while (intentos < 5) {
            System.out.println("Intentos: " + intentos);

            imprimirAhorcado(letras, adivinadas);

            System.out.print("Ingrese una letra o palabra: ");
            String input = scanner.nextLine().toLowerCase();

            System.out.println();
            System.out.println();

            if ( !validar(input) ) {
                //System.out.println("La entrada es invalida. Vuelva a \n");
            }
            else {
                if ( arriesgar(input, palabraElegida) ) {
                    if (input.length() == 1) {
                        if ( adivinadas.contains(input) ) {

                        }
                        else {
                            restantes.remove(input);
                            adivinadas.add(input);

                            if ( restantes.isEmpty() ) {
                                gano = true;
                                intentos = 5;
                            }
                            else {

                            }
                        }
                    }
                    else {
                        gano = true;
                        intentos = 5;
                    }
                }
                else {
                    intentos++;

                }
            }
        } // end while

        if (gano) {
            System.out.println("Felicidades!, acerto la palabra: " + palabraElegida);
        }
        else {
            System.out.println("Perdiste. Vuelva a intentarlo. La palabra era: " + palabraElegida);
        }
    }

    public static boolean validar(String input) {
        return !( input == null || input.isEmpty() || input.isBlank() );
    }

    public static void imprimirAhorcado(String[] letras, Set<String> adivinadas) {
        for (int i = 0; i < letras.length; i++) {
            if ( adivinadas.contains(letras[i]) ) {
                System.out.print(letras[i] + " ");
            }
            else {
                System.out.print("_ ");
            }
        }

        System.out.println();
        System.out.println();
    }

    public static void ahorcado(String path) {
    }

    public static boolean arriesgar(String input, String palabra) {
        /*if (input == null || !Ejercicio2.match("[a-zA-Z]+", input)){
            throw new IllegalStateException();
        }
/*
        if (palabra == null || !Ejercicio2.match("[a-zA-Z]+", palabra)) {
            throw new IllegalStateException();
        }
*/
        // se fija si es una letra ( == 1) o una palabra ( > 1)
        if (input.length() == 1) {
            return palabra.contains(input);
        }
        else {
            return palabra.equals(input);
        }
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

        Random random = new Random();

        // resultado = (int)( Math.random() * (upperBound * 10) % (upperBound + 1 - lowerBound) + lowerBound );

        resultado = random.nextInt(upperBound + 1 - lowerBound) + lowerBound;

        System.out.println(resultado);

        return resultado;
    }
}
