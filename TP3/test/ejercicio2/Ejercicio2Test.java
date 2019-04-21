package ejercicio2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class Ejercicio2Test {

    @Before
    public void setUp() throws Exception {
        Ejercicio2.getPadres().clear();
        Ejercicio2.getMadres().clear();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void match() {
        // ARRANGE
        String pattern1 = "madre\\([a-zA-Z]+,[a-zA-Z]+\\)";
        String line = "madre(Julieta,Mariana)";

        String pattern2 = "padre\\([a-zA-Z]+,[a-zA-Z]+\\)";
        String line2 = "padre(Julieta,Mario)";

        // ACT
        boolean resultado = Ejercicio2.match(pattern1, line);
        boolean resultado2 = Ejercicio2.match(pattern2, line2);

        // ASSERT
        Assert.assertTrue(resultado);
        Assert.assertTrue(resultado2);
    }

    @Test
    public void esHermano_SonHermanos_DevuelveTrue() {
        // ARRANGE
        String hermano1 = "Hernan";
        String hermano2 = "Kevin";
        String padre = "Mario";
        String madre = "Liliana";

        Ejercicio2.getPadres().put(hermano1, padre);
        Ejercicio2.getMadres().put(hermano1, madre);
        Ejercicio2.getPadres().put(hermano2, padre);
        Ejercicio2.getMadres().put(hermano2, madre);

        // ACT
        boolean resultado = Ejercicio2.esHermano(hermano1, hermano2);

        // ASSERT
        Assert.assertTrue(resultado);
    }

    @Test
    public void esHermano_NoSonHermanos_DevuelveFalse() {
        // ARRANGE
        String hermano1 = "Hernan";
        String hermano2 = "Kevin";
        String padre = "Mario";
        String madre = "Liliana";

        Ejercicio2.getPadres().put(hermano1, padre);
        Ejercicio2.getMadres().put(hermano1, madre);
        Ejercicio2.getPadres().put(hermano2, "Augusto");
        Ejercicio2.getMadres().put(hermano2, "Mariana");

        // ACT
        boolean resultado = Ejercicio2.esHermano(hermano1, hermano2);

        // ASSERT
        Assert.assertFalse(resultado);
    }

    @Test
    public void esAbuelo_EsElAbueloPorParteDelPadre_DevuelveTrue() {
        // ARRANGE
        String abuelo = "Luis";
        String nieto = "Kevin";
        String padre = "Mario";

        Ejercicio2.getPadres().put(nieto, padre);
        Ejercicio2.getPadres().put(padre, abuelo);

        // ACT
        boolean resultado = Ejercicio2.esAbuelo(abuelo, nieto);

        // ASSERT
        Assert.assertTrue(resultado);
    }

    @Test
    public void esAbuelo_EsElAbueloPorParteDeLaMadre_DevuelveTrue() {
        // ARRANGE
        String abuelo = "Luis";
        String nieto = "Kevin";
        String madre = "Mariana";

        Ejercicio2.getPadres().put(nieto, madre);
        Ejercicio2.getPadres().put(madre, abuelo);

        // ACT
        boolean resultado = Ejercicio2.esAbuelo(abuelo, nieto);

        // ASSERT
        Assert.assertTrue(resultado);
    }

    @Test
    public void esAbuelo_NoEsElAbuelo_DevuelveFalse() {
        // ARRANGE
        String abuelo = "Luis";
        String nieto = "Kevin";
        String madre = "Mariana";

        //Ejercicio2.getPadres().put(nieto, madre);
        //Ejercicio2.getPadres().put(madre, abuelo);

        // ACT
        boolean resultado = Ejercicio2.esAbuelo(abuelo, nieto);

        // ASSERT
        Assert.assertFalse(resultado);
    }

    @Test
    public void cargar() throws IOException {
        // ACT
        Ejercicio2.cargar("ejercicio2_test.txt");

        // ASSERT
        Assert.assertEquals(3, Ejercicio2.getPadres().size());
        Assert.assertEquals(2, Ejercicio2.getMadres().size());
    }

    @Test
    public void responder() throws IOException {
        // ARRANGE
        String pregunta1 = "esHermano(Kevin,Hernan)";
        String pregunta2 = "esAbuelo(Kevin,Luis)";
        String pregunta3 = "esHermano(Kevin,Nicolas)";

        Ejercicio2.cargar("ejercicio2_test2.txt");

        // ACT
        boolean result1 = Ejercicio2.responder(pregunta1);
        boolean result2 = Ejercicio2.responder(pregunta2);
        boolean result3 = Ejercicio2.responder(pregunta3);

        // ASSERT
        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
        Assert.assertFalse(result3);
    }
}