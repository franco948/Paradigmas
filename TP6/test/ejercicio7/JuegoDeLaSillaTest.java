package ejercicio7;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

    @Test(expected = IllegalStateException.class)
    public void jugar_MenosDeDosJugadores_Error() throws Exception {
        // ARRANGE
        List<Jugador> jugadores = new LinkedList<>();
        jugadores.add(new Jugador("Dario"));

        JuegoDeLaSilla juegoDeLaSilla = new JuegoDeLaSilla(1);


        // ACT
        juegoDeLaSilla.jugar(jugadores);
    }
/*
    @Test
    public void nuevaVuelta() throws Exception {
        // ARRANGE
        List<Jugador> jugadores = new LinkedList<>();
        jugadores.add(new Jugador("Dario"));
        jugadores.add(new Jugador("Hernan"));
        jugadores.add(new Jugador("Alejandro"));
        jugadores.add(new Jugador("Julian"));
        jugadores.add(new Jugador("Mariana"));

        JuegoDeLaSilla juegoDeLaSilla = new JuegoDeLaSilla(1);

        // ACT
        Jugador perdedorResultado = juegoDeLaSilla.nuevaVuelta();

        // ASSERT
        Assert.assertTrue( jugadores.size() == 4 );

        Assert.assertFalse( jugadores.contains(perdedorResultado) );
    }*/

    @Test
    public void imprimir() {
    }

    @After
    public void tearDown() throws Exception {
    }
}