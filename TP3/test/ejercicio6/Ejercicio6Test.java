package ejercicio6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class Ejercicio6Test {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void transponer() {
        // ARRANGE
        String pathEntrada = "matriz.txt";
        String pathSalida = "matriz_traspuesta.txt";

        String[][] T = new String[][] {
                {}
        };

        // ACT
        try {
            Ejercicio6.trasponer(pathEntrada, pathSalida);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // ASSERT
    }
}