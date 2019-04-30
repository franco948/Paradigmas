package ejercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio2 {

    private static TreeMap<String, String> padres = new TreeMap<String,String>();
    private static TreeMap<String, String> madres = new TreeMap<String,String>();

    public static void main(String[] args) {

        try {
            //cargar("F:\\dev\\Paradigmas\\TP3\\ejercicio2_test2.txt");
            cargar("TP3\\ejercicio2_test2.txt");
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String pregunta = scanner.nextLine();

            System.out.println(responder(pregunta));
        }
    }

    public static TreeMap<String, String> getPadres() {
        return padres;
    }

    public static TreeMap<String, String> getMadres() {
        return madres;
    }

    public static boolean responder(String pregunta) {

        if ( match("esHermano\\([a-zA-Z]+,[a-zA-Z]+\\)", pregunta) ) {
            String substring = pregunta.substring(10, pregunta.length() - 1);

            String[] nombres = substring.split(",");

            return esHermano(nombres[0], nombres[1]);
        }
        else if ( match("esAbuelo\\([a-zA-Z]+,[a-zA-Z]+\\)", pregunta) ) {
            String substring = pregunta.substring(9, pregunta.length() - 1);

            String[] nombres = substring.split(",");

            return esAbuelo(nombres[0], nombres[1]);
        }

        return false;
    }

    public static void cargar(String path) throws FileNotFoundException, IOException {

        padres.clear();
        madres.clear();

        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line = reader.readLine();

        while (line != null) {

            if ( match("padre\\([a-zA-Z]+,[a-zA-Z]+\\)", line) ){

                String substring = line.substring(6, line.length() - 1);

                String[] nombres = substring.split(",");

                padres.put(nombres[0], nombres[1]);
            }
            else if ( match("madre\\([a-zA-Z]+,[a-zA-Z]+\\)", line) ) {
                String substring = line.substring(6, line.length() - 1);

                String[] nombres = substring.split(",");

                madres.put(nombres[0], nombres[1]);
            }
            else {
                throw new IllegalStateException();
            }

            line = reader.readLine();
        }

        reader.close();
    }

    public static boolean match(String pattern, String line) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(line);
        return m.matches();
    }

    public static boolean esHermano(String unNombre, String otroNombre) {

        if (padres.containsKey(unNombre) && madres.containsKey(unNombre) &&
                padres.containsKey(otroNombre) && madres.containsKey(otroNombre)) {

            return padres.get(unNombre).equals(padres.get(otroNombre)) &&
                    madres.get(unNombre).equals(madres.get(otroNombre));
        }

        return false;
    }

    public static boolean esAbuelo(String nieto, String abuelo) {

        if ( padres.containsKey(nieto) ){

            String padre = padres.get(nieto);

            if ( padres.containsKey(padre) ) {
                 if ( padres.get(padre).equals(abuelo) ) {
                     return true;
                 }
            }
        }

        if ( madres.containsKey(nieto) ) {
            String madre = madres.get(nieto);

            if ( madres.containsKey(madre) ) {
                if ( madres.get(madre).equals(abuelo) ){
                    return true;
                }
            }
        }

        return false;
    }
}
