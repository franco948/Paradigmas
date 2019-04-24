package ejercicio9;

public class Ejercicio9 {

    private static int index = 0;

    public static String[] combinar(String[] letras, int k) {

        if ( k < 0 ) throw new IndexOutOfBoundsException();
        if ( k == 0 ) return new String[0];
        if ( letras.length == 0 ) throw new IllegalStateException();

        index = 0;

        String[] combinaciones = new String[(int)Math.pow(letras.length, k)];

        combinarRecursivo(letras,"", k, combinaciones);

        return combinaciones;
    }

    public static void combinarRecursivo(String[] letras, String actual, int k, String[] combinaciones) {

        if(actual.length() == k) {
            System.out.println(actual);
            combinaciones[index++] = actual;
        }
        else {
            // TODO: CAMBIAR POR UN FOR
            for (int i = 0; i < letras.length; i++) {
                combinarRecursivo(letras, actual + letras[i], k, combinaciones);
            }
            //combinarRecursivo(letras,actual + "N", k, combinaciones);
            //combinarRecursivo(letras,actual + "R", k, combinaciones);
        }
    }
}
