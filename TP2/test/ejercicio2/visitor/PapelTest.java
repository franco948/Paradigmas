package ejercicio2.visitor;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PapelTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void aceptar() {
        // ARRANGE
        Visitor visitor = new VisitorConcreto();
        Papel papel = new Papel();

        Piedra piedra = new Piedra();
        Papel papel2 = new Papel();
        Tijera tijera = new Tijera();

        // ACT
        Resultado resultado1 = papel.Aceptar(visitor, piedra);
        Resultado resultado2 = papel.Aceptar(visitor, papel2);
        Resultado resultado3 = papel.Aceptar(visitor, tijera);

        // ASSERT
        Assert.assertEquals(Resultado.Victoria, resultado1);
        Assert.assertEquals(Resultado.Empate, resultado2);
        Assert.assertEquals(Resultado.Derrota, resultado3);
    }

    @Test(expected = IllegalStateException.class)
    public void aceptar_Null_LanzaError() {
        // ARRANGE
        Visitor visitor = new VisitorConcreto();
        Papel papel = new Papel();

        // ACT
        papel.Aceptar(visitor, null);
    }
}