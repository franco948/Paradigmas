package ejercicio7;

public class Ejercicio7 {

    public static int factorial(int n) {

        if ( n < 0 ) throw new IndexOutOfBoundsException();

        if ( n == 0 ) return 1;

        return n * factorial(n - 1);
    }
}
