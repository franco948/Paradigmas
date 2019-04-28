package ejercicio4;

import ejercicio2.Ejercicio2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class Ejercicio4Test {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void match() {
        // ARRANGE
        //String pattern = "[a-z\\sA-Z]+";
        String pattern = "[a-zA-Z]+";

        String[] lines = new String[] {
                "vaca",
                "pinocho",
                "faro"
                //"el zorro"
        };

        // ACT - ASSERT
        for (int i = 0; i < lines.length; i++) {

            Assert.assertTrue(Ejercicio2.match(pattern, lines[i]));
        }
    }

    @Test
    public void leerPalabras() throws IOException {
        // ARRANGE
        String path = "ejercicio4.txt";

        List<String> expected = new LinkedList<>();
        expected.add("oveja");
        expected.add("abeja");
        expected.add("vaca");
        expected.add("martillo");

        // ACT
        List<String> resultado = Ejercicio4.leerPalabras(path);

        // ASSERT
        Assert.assertEquals(expected.size(), resultado.size());

        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i), resultado.get(i));
        }
    }

    @Test
    public void elegirPalabra() {
        // ARRANGE
        List<String> expected = new LinkedList<>();
        expected.add("oveja");
        expected.add("abeja");
        expected.add("vaca");
        expected.add("martillo");

        // ACT
        String resutado = Ejercicio4.elegirPalabra(expected);

        // ASSERT
        System.out.println(resutado);

        Assert.assertTrue(!resutado.isBlank() && !resutado.isEmpty());

        Assert.assertTrue(expected.contains(resutado));
    }
/*
    @Test(expected = IllegalStateException.class)
    public void arriesgar_InputEnBlanco_LanzaError() {
        // ARRANGE
        String input = "   ";
        String palabra = "oveja";

        // ACT
        Ejercicio4.arriesgar(input, palabra);
    }

    @Test(expected = IllegalStateException.class)
    public void arriesgar_InputEnNull_LanzaError() {
        // ARRANGE
        String input = null;
        String palabra = "oveja";

        // ACT
        Ejercicio4.arriesgar(input, palabra);
    }*/
}