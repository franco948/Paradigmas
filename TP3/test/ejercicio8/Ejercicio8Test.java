package ejercicio8;

import ejercicio8.Ejercicio8;
import org.junit.Assert;

public class Ejercicio8Test {

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void fibonacci_conArgumentoNegativo_LanzaError() {

        // ACT
        int r1 = Ejercicio8.fibonacci(-1);
    }

    @org.junit.Test
    public void fibonacci_conArgumentoPositivo_Ok() {

        // ARRANGE
        int e1 = 0;
        int e2 = 1;
        int e3 = 1;
        int e4 = 2;
        int e5 = 3;
        int e6 = 5;
        int e7 = 8;

        // ACT
        int r1 = Ejercicio8.fibonacci(0);
        int r2 = Ejercicio8.fibonacci(1);
        int r3 = Ejercicio8.fibonacci(2);
        int r4 = Ejercicio8.fibonacci(3);
        int r5 = Ejercicio8.fibonacci(4);
        int r6 = Ejercicio8.fibonacci(5);
        int r7 = Ejercicio8.fibonacci(6);

        // ASSERT
        Assert.assertEquals(e1, r1);
        Assert.assertEquals(e2, r2);
        Assert.assertEquals(e3, r3);
        Assert.assertEquals(e4, r4);
        Assert.assertEquals(e5, r5);
        Assert.assertEquals(e6, r6);
        Assert.assertEquals(e7, r7);
    }
}