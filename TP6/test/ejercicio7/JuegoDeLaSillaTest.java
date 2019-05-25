package ejercicio7;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class JuegoDeLaSillaTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void jugar() throws Exception {
        // ARRANGE
        List<Jugador> jugadores = new LinkedList<>();
        jugadores.add(new Jugador("Dario"));
        jugadores.add(new Jugador("Hernan"));
        jugadores.add(new Jugador("Alejandro"));
        jugadores.add(new Jugador("Julian"));
        jugadores.add(new Jugador("Mariana"));

        JuegoDeLaSilla juegoDeLaSilla = new JuegoDeLaSilla(1);

        // ACT
        Jugador ganadorResultado = juegoDeLaSilla.jugar(jugadores);

        // ASSERT
        Assert.assertTrue( jugadores.size() == 1 );

        Assert.assertEquals( jugadores.get(0), ganadorResultado );
    }

    @Test
    public void nuevaVuelta() {
    }

    @Test
    public void imprimir() {
    }

    @After
    public void tearDown() throws Exception {
    }
}