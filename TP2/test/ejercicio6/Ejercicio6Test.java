package ejercicio6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class Ejercicio6Test {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void merge() {
        // ARRANGE


        // ACT
        try {
            Ejercicio6.merge("archivo1.txt", "archivo2.txt", "merge.txt");
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // ASSERT

    }
}