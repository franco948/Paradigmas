package ejercicio5;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio5Test {

    @Test
    public void obtenerPrimosGemelos() {
        // Arrange

        // Act
        int[] r1 = Ejercicio5.obtenerPrimosGemelos(1);
        int[] r2 = Ejercicio5.obtenerPrimosGemelos(3);
        int[] r3 = Ejercicio5.obtenerPrimosGemelos(4);
        int[] r4 = Ejercicio5.obtenerPrimosGemelos(5);
        int[] r5 = Ejercicio5.obtenerPrimosGemelos(6);
        int[] r6 = Ejercicio5.obtenerPrimosGemelos(7);
        int[] r7 = Ejercicio5.obtenerPrimosGemelos(12);
        int[] r8 = Ejercicio5.obtenerPrimosGemelos(2);

        // Assert
        Assert.assertArrayEquals(new int[] {1, 3}, r1);
        Assert.assertArrayEquals(new int[] {3, 5}, r2);
        Assert.assertArrayEquals(new int[] {5, 7}, r3);
        Assert.assertArrayEquals(new int[] {5, 7}, r4);
        Assert.assertArrayEquals(new int[] {11, 13}, r5);
        Assert.assertArrayEquals(new int[] {11, 13}, r6);
        Assert.assertArrayEquals(new int[] {17, 19}, r7);
        Assert.assertArrayEquals(new int[] {3, 5}, r8);
    }
}