package ejercicio6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

        try {
            // ARRANGE
            String[] merge = new String[] {
                    "1234,public void hola(),public void hi()",
                    "1235,public int calcular(),public double calcular()"
            };

            // ACT
            Ejercicio6.merge("archivo1.txt", "archivo2.txt", "merge.txt");

            // ASSERT
            BufferedReader reader = new BufferedReader(new FileReader("merge.txt"));

            String line = reader.readLine();

            int i = 0;
            while(line != null) {
                Assert.assertEquals(merge[i++], line);
                line = reader.readLine();
            }

            Assert.assertEquals(merge.length, i);
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}