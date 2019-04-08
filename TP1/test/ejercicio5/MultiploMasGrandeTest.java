package ejercicio5;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiploMasGrandeTest {

    @Test
    public void encontrarMultiploMasGrande() {
        // Arrange
        MultiploMasGrande m = new MultiploMasGrande();

        // Act
        int r1 = m.encontrarMultiploMasGrande(3, 9);
        int r2 = m.encontrarMultiploMasGrande(1001, 1); // con x mayor a 1000
        int r3 = m.encontrarMultiploMasGrande(1, 1001); // con y mayor a 1000
        int r4 = m.encontrarMultiploMasGrande(1000, 10); // probando limite superior
        int r5 = m.encontrarMultiploMasGrande(-3, -9); // probando negativos
        int r6 = m.encontrarMultiploMasGrande(1000, 1000);
        int r7 = m.encontrarMultiploMasGrande(0, 10); // probando con cero

        // Assert
        Assert.assertEquals(999, r1);
        Assert.assertEquals(-1, r2);
        Assert.assertEquals(-1, r3);
        Assert.assertEquals(1000, r4);
        Assert.assertEquals(999, r5);
        Assert.assertEquals(1000, r6);
        Assert.assertEquals(-1, r7);
    }
}