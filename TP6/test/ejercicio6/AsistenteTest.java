package ejercicio6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AsistenteTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void imprimirCredencial() {
        // ARRANGE
        Congreso c = new Congreso("CITII", 200);

        Asistente a1 = new Alumno("Hernan","Gomez","UAI", 3);

        c.agregar(a1);

        // ACT
        String credencial = a1.imprimirCredencial();

        // ASSERT
        Assert.assertTrue(credencial.contains(a1.getNombre()));
        Assert.assertTrue(credencial.contains(a1.getApellido()));
        Assert.assertTrue(credencial.contains(a1.getInstituto()));
        Assert.assertTrue(credencial.contains(c.getNombre()));
    }
}