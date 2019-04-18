package ejercicio9;

public class Ejercicio9 {

    private static int index = 0;

    public static String[] combinar(int k) {

        if ( k < 0 ) throw new IndexOutOfBoundsException();
        if ( k == 0 ) return new String[0];

        index = 0;

        String[] combinaciones = new String[(int)Math.pow(2, k)];

        combinarRecursivo("", k, combinaciones);

        return combinaciones;
    }

    public static void combinarRecursivo(String actual, int k, String[] combinaciones) {

        if(actual.length() == k) {
            System.out.println(actual);
            combinaciones[index++] = actual;
        }
        else {
            // TODO: CAMBIAR POR UN FOR
            combinarRecursivo(actual + "N", k, combinaciones);
            combinarRecursivo(actual + "R", k, combinaciones);
        }
    }
}
