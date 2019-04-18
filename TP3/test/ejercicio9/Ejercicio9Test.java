package ejercicio9;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio9Test {

    @Test(expected =  IndexOutOfBoundsException.class)
    public void combinar_conArgumentoNegativo_LanzaError() {

        // ACT
        Ejercicio9.combinar(-1);
    }

    @Test
    public void combinar_conCero_DevuelveArrayVacio() {

        // ARRANGE
        int k = 0;
        String[] expected = new String[0];

        // ACT
        String[] result = Ejercicio9.combinar(k);

        // ASSERT
        Assert.assertEquals(expected.length, result.length);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void combinar_conArgumentoIgualAUno_DevuelveDosCombinaciones() {

        // ARRANGE
        int k = 1;
        String[] expected = new String[] {"N", "R"};

        // ACT
        String[] result = Ejercicio9.combinar(k);

        // ASSERT
        Assert.assertEquals(expected.length, result.length);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void combinar_conArgumentoIgualADos_DevuelveTresCombinaciones() {

        // ARRANGE
        int k = 2;
        String[] expected = new String[] {"NN", "NR", "RN", "RR"};

        // ACT
        String[] result = Ejercicio9.combinar(k);

        // ASSERT
        Assert.assertEquals(expected.length, result.length);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void combinar_conArgumentoIgualATres_DevuelveOchoCombinaciones() {

        // ARRANGE
        int k = 3;
        String[] expected = new String[] {"NNN", "NNR", "NRN", "NRR", "RNN", "RNR", "RRN", "RRR"};

        // ACT
        String[] result = Ejercicio9.combinar(k);

        // ASSERT
        Assert.assertEquals(expected.length, result.length);
        Assert.assertArrayEquals(expected, result);
    }
}