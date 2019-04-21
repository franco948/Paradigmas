package ejercicio4;

import ejercicio2.Ejercicio2;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        String pattern = "[a-z\\sA-Z]+";

        String[] lines = new String[] {
                "vaca",
                "pinocho",
                "faro",
                "el zorro"
        };

        // ACT - ASSERT
        for (int i = 0; i < lines.length; i++) {

            Assert.assertTrue(Ejercicio2.match(pattern, lines[i]));
        }
    }
}