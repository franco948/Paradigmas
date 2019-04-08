package ejercicio1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio1Test {

    @Test
    public void devolverDosMasAltos() {
        // Arrange
        Ejercicio1 e1 = new Ejercicio1();

        // Act
        int[] r1 = e1.devolverDosMasAltos(new int[] {7, 56, -5, 4, 72, 40});
        int[] r2 = e1.devolverDosMasAltos(new int[] {});
        int[] r3 = e1.devolverDosMasAltos(new int[] {9});
        int[] r4 = e1.devolverDosMasAltos(new int[] {-14, -6, -12, -60, -1, -10});
        int[] r5 = e1.devolverDosMasAltos(new int[] {40, 56});

        // Assert
        Assert.assertArrayEquals(new int[] {72, 56}, r1);
        Assert.assertArrayEquals(new int[] {}, r2);
        Assert.assertArrayEquals(new int[] {9}, r3);
        Assert.assertArrayEquals(new int[] {-1, -6}, r4);
        Assert.assertArrayEquals(new int[] {56, 40}, r5);
    }
}