package ejercicio9;

import ejercicio6.Ejercicio6;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio9Test {

    @Test(expected =  IndexOutOfBoundsException.class)
    public void combinar_conArgumentoNegativo_LanzaError() {
        // ARRANGE
        int k = -1;
        String[] letras = new String[] {"B", "N"};

        // ACT
        Ejercicio9.combinar(letras, k);
    }

    @Test(expected =  IllegalStateException.class)
    public void combinar_KDistintoDeCeroYArrayConLetras_LanzaError() {
        // ARRANGE
        int k = 3;
        String[] letras = new String[0];

        // ACT
        Ejercicio9.combinar(letras, k);
    }

    @Test
    public void combinar_KIgualCero_DevuelveArrayVacio() {
        // ARRANGE
        int k = 0;
        String[] letras = new String[] {"R", "N"};
        String[] expected = new String[0];

        // ACT
        String[] result = Ejercicio9.combinar(letras, k);

        // ASSERT
        Assert.assertEquals(expected.length, result.length);
        Assert.assertArrayEquals(expected, result);
    }

    /*@Test
    public void combinar_conArgumentoIgualAUno_DevuelveDosCombinaciones() {

        // ARRANGE
        int k = 1;
        String[] expected = new String[] {"N", "R"};

        // ACT
        String[] result = Ejercicio9.combinar(k);

        // ASSERT
        Assert.assertEquals(expected.length, result.length);
        Assert.assertArrayEquals(expected, result);
    }*/

    /*@Test
    public void combinar_conArgumentoIgualADos_DevuelveTresCombinaciones() {

        // ARRANGE
        int k = 2;
        String[] expected = new String[] {"NN", "NR", "RN", "RR"};

        // ACT
        String[] result = Ejercicio9.combinar(k);

        // ASSERT
        Assert.assertEquals(expected.length, result.length);
        Assert.assertArrayEquals(expected, result);
    }*/

    /*@Test
    public void combinar_conArgumentoIgualATres_DevuelveOchoCombinaciones() {

        // ARRANGE
        int k = 3;
        String[] expected = new String[] {"NNN", "NNR", "NRN", "NRR", "RNN", "RNR", "RRN", "RRR"};

        // ACT
        String[] result = Ejercicio9.combinar(k);

        // ASSERT
        Assert.assertEquals(expected.length, result.length);
        Assert.assertArrayEquals(expected, result);
    }*/

    @Test
    public void combinar_KIgual2YDosLetras_Ok() {
        // ARRANGE
        int k = 2;

        String[] letras = new String[] {
                "R", "N"
        };

        String[] expected = new String[] {
                "RR", "RN", "NR", "NN"
        };

        // ACT
        String[] resultado = Ejercicio9.combinar(letras, k);

        // ASSERT
        Assert.assertEquals(expected.length, resultado.length);
        Assert.assertArrayEquals(expected, resultado);
    }

    @Test
    public void combinar_KIgual3YDosLetras_Ok() {
        // ARRANGE
        int k = 3;

        String[] letras = new String[] {
                "R", "N"
        };

        String[] expected = new String[] {
                "RRR", "RRN", "RNR", "RNN", "NRR", "NRN", "NNR", "NNN"
        };

        // ACT
        String[] resultado = Ejercicio9.combinar(letras, k);

        // ASSERT
        Assert.assertEquals(expected.length, resultado.length);
        Assert.assertArrayEquals(expected, resultado);
    }

    @Test
    public void combinar_KIgual3YTresLetras_Ok() {
        // ARRANGE
        int k = 3;

        String[] letras = new String[] {
                "R", "N", "S"
        };

        String[] expected = new String[] {
                "RRR", "RRN", "RRS", "RNR", "RNN", "RNS", "RSR", "RSN", "RSS",
                "NRR", "NRN", "NRS", "NNR", "NNN", "NNS", "NSR", "NSN", "NSS",
                "SRR", "SRN", "SRS", "SNR", "SNN", "SNS", "SSR", "SSN", "SSS"
        };

        // ACT
        String[] resultado = Ejercicio9.combinar(letras, k);

        // ASSERT
        Assert.assertEquals(expected.length, resultado.length);
        Assert.assertArrayEquals(expected, resultado);
    }

    @Test
    public void combinar_KIgual2YTresLetras_Ok() {
        // ARRANGE
        int k = 2;

        String[] letras = new String[] {
                "R", "N", "S"
        };

        String[] expected = new String[] {
                "RR", "RN", "RS",
                "NR", "NN", "NS",
                "SR", "SN", "SS"
        };

        // ACT
        String[] resultado = Ejercicio9.combinar(letras, k);

        // ASSERT
        Assert.assertEquals(expected.length, resultado.length);
        Assert.assertArrayEquals(expected, resultado);
    }
}