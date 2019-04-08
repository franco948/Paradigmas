package ejercicio2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DigitoMasAltoTest {

    @Test
    public void encontrarDigitoMasAlto() {
        // Arrange
        DigitoMasAlto digitoMasAlto = new DigitoMasAlto();

        // Act
        int r1 = digitoMasAlto.encontrarDigitoMasAlto(1924);
        int r2 = digitoMasAlto.encontrarDigitoMasAlto(0);
        int r3 = digitoMasAlto.encontrarDigitoMasAlto(1554);
        int r4 = digitoMasAlto.encontrarDigitoMasAlto(-461);
        int r5 = digitoMasAlto.encontrarDigitoMasAlto(5);
        int r6 = digitoMasAlto.encontrarDigitoMasAlto(6032);

        // Assert
        Assert.assertEquals(9, r1);
        Assert.assertEquals(0, r2);
        Assert.assertEquals(5, r3);
        Assert.assertEquals(6, r4);
        Assert.assertEquals(5, r5);
        Assert.assertEquals(6, r6);
    }
}