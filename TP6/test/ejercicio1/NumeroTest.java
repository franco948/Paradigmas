package ejercicio1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumeroTest
{
    @Test
    public void sumar_DosNumeroPositivos_Ok()
    {
        // ARRANGE
        Numero numero = new Numero();

        int a = 5;
        int b = 3;
        int sumaEsperada = 8;

        // ACT
        int sumaActual = numero.sumar(a, b);

        // ASSERT
        Assert.assertEquals(sumaEsperada, sumaActual);
    }

    @Test
    public void sumar_PositivoYNegativo_Ok()
    {
        // ARRANGE
        Numero numero = new Numero();

        int a = 4;
        int b = -2;
        int sumaEsperada = 2;

        // ACT
        int sumaActual = numero.sumar(a, b);

        // ASSERT
        Assert.assertEquals(sumaEsperada, sumaActual);
    }

    @Test
    public void sumar_NegativoYPositivo_Ok()
    {
        // ARRANGE
        Numero numero = new Numero();

        int a = -99;
        int b = 40;
        int sumaEsperada = -59;

        // ACT
        int sumaActual = numero.sumar(a, b);

        // ASSERT
        Assert.assertEquals(sumaEsperada, sumaActual);
    }

    @Test
    public void sumar_DosNumerosNegativos_Ok()
    {
        // ARRANGE
        Numero numero = new Numero();

        int a = -13;
        int b = -9;
        int sumaEsperada = -22;

        // ACT
        int sumaActual = numero.sumar(a, b);

        // ASSERT
        Assert.assertEquals(sumaEsperada, sumaActual);
    }

    @Test
    public void restar_DosNumerosPositivos_Ok()
    {
        // ARRANGE
        Numero numero = new Numero();

        int a = 5;
        int b = 13;

        int restaEsperada = -8;

        // ACT
        int restaActual = numero.restar(a, b);

        // ASSERT
        Assert.assertEquals(restaEsperada, restaActual);
    }

    @Test
    public void restar_PositivoYNegativo_Ok()
    {
        // ARRANGE
        Numero numero = new Numero();

        int a = 65;
        int b = -5;

        int restaEsperada = 70;

        // ACT
        int restaActual = numero.restar(a, b);

        // ASSERT
        Assert.assertEquals(restaEsperada, restaActual);
    }

    @Test
    public void restar_NegativoYPositivo_Ok()
    {
        // ARRANGE
        Numero numero = new Numero();

        int a = -9;
        int b = 40;

        int restaEsperada = -49;

        // ACT
        int restaActual = numero.restar(a, b);

        // ASSERT
        Assert.assertEquals(restaEsperada, restaActual);
    }

    @Test
    public void restar_DosNumerosNegativos_Ok()
    {
        // ARRANGE
        Numero numero = new Numero();

        int a = -3;
        int b = -6;

        int restaEsperada = 3;

        // ACT
        int restaActual = numero.restar(a, b);

        // ASSERT
        Assert.assertEquals(restaEsperada, restaActual);
    }
}