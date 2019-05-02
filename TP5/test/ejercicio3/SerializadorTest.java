package ejercicio3;

import ejercicio1.EntidadSerializable;
import ejercicio4.Persona;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.Assert.*;

public class SerializadorTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void serializar() throws Exception {
        // ARRANGE
        Persona persona = new Persona("Hernan", "Gomez", (short)34, "Calle Falsa 123", true, 1124558461);
        Serializador serializador = new Serializador();

        String expectedFile = "\"Persona\">>\"nombre\":\"Hernan\",\"apellido\":\"Gomez\",\"edad\":34,\"soltero\":true,";

        // ACT
        serializador.serializar(persona);

        // ASSERT
        BufferedReader reader = new BufferedReader(new FileReader("ejercicio4.Persona"));

        String line = reader.readLine();

        Assert.assertEquals( expectedFile, line );

        reader.close();
    }

    @Test(expected = IllegalStateException.class)
    public void serializar_EntidadNoSerializable_Error() throws Exception {
        // ARRANGE
        EntidadNoSerializable entidad = new EntidadNoSerializable();
        Serializador serializador = new Serializador();

        // ACT
        serializador.serializar(entidad);
    }
}