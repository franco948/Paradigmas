package ejercicio2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio2Test {

    @Test
    public void devolverNumeroConMayorCantidadDePares() {
        // Arrange
        Ejercicio2 e2 = new Ejercicio2();

        // Act
        int r1 = e2.devolverNumeroConMayorCantidadDePares(new int[] {});
        int r2 = e2.devolverNumeroConMayorCantidadDePares(new int[] {5, 3, 1});
        int r3 = e2.devolverNumeroConMayorCantidadDePares(new int[] {4, 22, 34});
        int r4 = e2.devolverNumeroConMayorCantidadDePares(new int[] {-426, 546, 8});
        int r5 = e2.devolverNumeroConMayorCantidadDePares(new int[] {5});
        int r6 = e2.devolverNumeroConMayorCantidadDePares(new int[] {4});

        // Assert
        Assert.assertEquals(-1, r1);
        Assert.assertEquals(-1, r2);
        Assert.assertEquals(22, r3);
        Assert.assertEquals(-426, r4);
        Assert.assertEquals(-1, r5);
        Assert.assertEquals(4, r6);
    }
}