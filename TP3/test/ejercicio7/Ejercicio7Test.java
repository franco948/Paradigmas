package ejercicio7;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio7Test {

    @Test(expected = IndexOutOfBoundsException.class)
    public void factorial_conArgumentoNegativo_LanzaError() {

        // ACT
        Ejercicio7.factorial(-1);
    }

    @Test
    public void factorial_deCero_devuelveUno() {

        // ARRANGE
        int expected = 1;

        // ACT
        int result = Ejercicio7.factorial(0);

        // ASSERT
        Assert.assertEquals(expected, result);
    }

    @Test
    public void factorial_conArgumentoValido_Ok() {

        // ARRANGE
        int e1 = 1;
        int e2 = 2;
        int e3 = 6;
        int e4 = 24;
        int e5 = 120;

        // ACT
        int r1 = Ejercicio7.factorial(1);
        int r2 = Ejercicio7.factorial(2);
        int r3 = Ejercicio7.factorial(3);
        int r4 = Ejercicio7.factorial(4);
        int r5 = Ejercicio7.factorial(5);

        // ASSERT
        Assert.assertEquals(e1, r1);
        Assert.assertEquals(e2, r2);
        Assert.assertEquals(e3, r3);
        Assert.assertEquals(e4, r4);
        Assert.assertEquals(e5, r5);
    }
}