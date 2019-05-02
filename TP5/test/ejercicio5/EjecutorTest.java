package ejercicio5;

import ejercicio6.MasDeUnMetodoEjecutable;
import ejercicio6.MetodoEjecutable;
import ejercicio6.MetodoNoEjecutable;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class EjecutorTest {

    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(sysOut);
    }

    @Test (expected = IllegalStateException.class)
    public void run_MasDeUnMetodoEjecutable_Error() throws Exception {
        // ARRANGE
        Ejecutor ejecutor = new Ejecutor();

        // ACT
        ejecutor.run(MasDeUnMetodoEjecutable.class);
    }

    @Test (expected = IllegalStateException.class)
    public void run_MetodoNoEjecutable_Error() throws Exception {
        // ARRANGE
        Ejecutor ejecutor = new Ejecutor();

        // ACT
        ejecutor.run(MetodoNoEjecutable.class);
    }

    @Test
    public void run() throws Exception {
        // ARRANGE
        Ejecutor ejecutor = new Ejecutor();

        // ACT
        ejecutor.run(MetodoEjecutable.class);

        // ASSERT
        Assert.assertTrue( outContent.toString().contains("MetodoEjecutable.metodo2") );
    }
}