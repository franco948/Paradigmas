package ejercicio7;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GPSTest {

    @Test
    public void calcularTiempoLlegadaEnMinutos() {
        // Arrange
        GPS gps = new GPS();

        // Act
        float r1 = gps.calcularTiempoLlegadaEnMinutos(100, 1000);
        float r2 = gps.calcularTiempoLlegadaEnMinutos(-1, 1000);
        float r3 = gps.calcularTiempoLlegadaEnMinutos(100, -1);
        float r4 = gps.calcularTiempoLlegadaEnMinutos(100, 0);

        // Assert
        Assert.assertEquals(600, r1, 0);
        Assert.assertEquals(-1, r2, 0);
        Assert.assertEquals(-1, r3, 0);
        Assert.assertEquals(0, r4, 0);
    }
}