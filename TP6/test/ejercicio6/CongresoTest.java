package ejercicio6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CongresoTest {

    private Asistente a1 = new Alumno("Hernan","Gomez","UAI", 3);
    private Asistente a2 = new Alumno("Emanuel","Lopez","UADE", 4);
    private Asistente a3 = new Presentador("Mariano","Gonzales", "Telecentro");
    private Asistente a4 = new Particular("Esteban", "Rodriguez","Lugar1","Jujuy");
    private Asistente a5 = new Particular("Sebastian", "Ramirez","Lugar2","Buenos Aires");

    private Congreso c = new Congreso("CITII", 100);

    @Before
    public void setUp() throws Exception {

        c.agregar(a1);
        c.agregar(a2);
        c.agregar(a3);
        c.agregar(a4);
        c.agregar(a5);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void imprimirAsistentes() {
        // ARRANGE

        // ACT
        String listadoAsistentes = c.imprimirAsistentes();

        // ASSERT
        for (Asistente a : c.getAsistentes()) {
            Assert.assertTrue(listadoAsistentes.contains(a.getNombre()));
            Assert.assertTrue(listadoAsistentes.contains(a.getApellido()));
        }
    }

    @Test
    public void precioACobrar() {
        // ARRANGE
        float e1 = 275.0f;
        float e2 = 300.0f;
        float e3 = 225.0f;
        float e4 = 290.0f;
        float e5 = 300.0f ;

        // ACT
        float r1 = c.precioACobrar(a1);
        float r2 = c.precioACobrar(a2);
        float r3 = c.precioACobrar(a3);
        float r4 = c.precioACobrar(a4);
        float r5 = c.precioACobrar(a5);

        // ASSERT
        Assert.assertEquals(e1,r1,0);
        Assert.assertEquals(e2,r2,0);
        Assert.assertEquals(e3,r3,0);
        Assert.assertEquals(e4,r4,0);
        Assert.assertEquals(e5,r5,0);
    }
}