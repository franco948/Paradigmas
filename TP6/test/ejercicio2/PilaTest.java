package ejercicio2;

import org.junit.Assert;

import static org.junit.Assert.*;

public class PilaTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test(expected = IllegalStateException.class)
    public void Pila_CapacidadNegativa_Error()
    {
        // ARRANGE
        int capacidadNegativa = -1;

        // ACT
        Pila pila = new Pila(capacidadNegativa);
    }

    @org.junit.Test(expected = IllegalStateException.class)
    public void Pila_CapacidadCero_Error()
    {
        // ARRANGE
        int capacidadCero = 0;

        // ACT
        Pila pila = new Pila(capacidadCero);

    }

    @org.junit.Test
    public void push_SinCapacidadMaxima_Ok() {
        // ARRANGE
        Pila pila = new Pila();

        int expectedLength = 3;

        // ACT
        pila.push('A');
        pila.push('B');
        pila.push('C');

        // ASSERT
        Assert.assertEquals( expectedLength, pila.length() );
    }

    @org.junit.Test
    public void push_CapacidadTres_Ok()
    {
        // ARRANGE
        int capacidad = 3;
        Pila pila = new Pila(capacidad);

        int expectedLength = 3;

        // ACT
        pila.push('A');
        pila.push('B');
        pila.push('C');

        // ASSERT
        Assert.assertEquals( expectedLength, pila.length() );
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void push_CapacidadTres_Error()
    {
        // ARRANGE
        int capacidad = 3;
        Pila pila = new Pila(capacidad);

        // ACT
        pila.push('A');
        pila.push('B');
        pila.push('C');

        pila.push('D'); // supera el limite
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void pop_PilaVacia_Error()
    {
        // ARRANGE
        Pila pila = new Pila();

        // ACT
        pila.pop();
    }

    @org.junit.Test
    public void pop_PilaConTresElementos_Ok()
    {
        // ARRANGE
        Pila pila = new Pila();

        pila.push('A');
        pila.push('B');
        pila.push('C');

        int expectedLength = 0;

        // ACT
        Character C = pila.pop();
        Character B = pila.pop();
        Character A = pila.pop();

        // ASSERT
        Assert.assertEquals( expectedLength, pila.length() );
        Assert.assertTrue( 'A' == A );
        Assert.assertTrue( 'B' == B );
        Assert.assertTrue( 'C' == C );
    }

    @org.junit.Test
    public void length() {
        // ARRANGE
        Pila pila = new Pila();

        // Assert.assertEquals( 0, pila.length() );

        pila.push('A');
        pila.push('A');
        pila.push('A');

        int expectedLength = 3;

        // ACT
        int actualLength = pila.length();

        // ASSERT
        Assert.assertEquals( expectedLength, actualLength );
    }

    @org.junit.Test
    public void isEmpty() {
        // ARRANGE
        Pila pila = new Pila();

        pila.push('A');
        pila.pop();

        // ACT
        boolean result = pila.isEmpty();

        // ASSERT
        Assert.assertTrue( result );
    }
}