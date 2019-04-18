package ejercicio9;

public class Ejercicio9Consola {

    public static void main(String[] args) {
        combinaciones(3);
    }

    public static void combinaciones(int k) {
        combinacionesRecursivo("", k);
    }

    public static void combinacionesRecursivo(String actual, int k) {

        if(actual.length() == k) {
            System.out.println(actual);
        }
        else {
            // TODO: CAMBIAR POR UN FOR
            combinacionesRecursivo(actual + "N", k);
            combinacionesRecursivo(actual + "R", k);
        }
    }
}
