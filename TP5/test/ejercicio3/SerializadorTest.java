package ejercicio3;

import ejercicio1.EntidadSerializable;
import ejercicio4.Persona;
import ejercicio4.PersonaRepository;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class SerializadorTest {

    @Before
    public void setUp() throws Exception {
    }

    @AfterClass
    public static void tearDown() throws Exception {
        String sql = "DROP TABLE Persona";

        Connection con = Conexion.createConnection();

        Conexion.write(sql, null, con);

        con.close();
    }

    @Test
    public void serializar() throws Exception {
        // ARRANGE
        Persona persona = new Persona("Hernan", "Gomez", (short)34, "Calle Falsa 123", true, 1124558461);
        Serializador serializador = new Serializador();

        String expectedFile = "\"Persona\">>nombre:\"Hernan\",apellido:\"Gomez\",edad:34,soltero:true,";

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

    @Test
    public void bdInsert() throws Exception {
        // ARRANGE
        Persona p1 = new Persona();
        p1.setNombre("Martin");
        p1.setApellido("Figueroa");
        p1.setEdad(24);
        p1.setSoltero(false);

        Persona p2 = new Persona();
        p2.setNombre("Hernan");
        p2.setApellido("Gomez");
        p2.setEdad(36);
        p2.setSoltero(true);

        Serializador serializador = new Serializador();

        Connection con = Conexion.createConnection();

        // ACT
        serializador.bdInsert(p1, con);
        serializador.bdInsert(p2, con);
        List<Persona> personas = PersonaRepository.devolverPersonas();

        con.close();

        // ASSERT
        Assert.assertEquals(2, personas.size());

        Persona pRes = personas.get(0);
        Assert.assertEquals( p1.getNombre(), pRes.getNombre() );
        Assert.assertEquals( p1.getApellido(), pRes.getApellido() );
        Assert.assertEquals( p1.getEdad(), pRes.getEdad() );
        Assert.assertEquals( p1.getSoltero(), pRes.getSoltero() );

        pRes = personas.get(1);
        Assert.assertEquals( p2.getNombre(), pRes.getNombre() );
        Assert.assertEquals( p2.getApellido(), pRes.getApellido() );
        Assert.assertEquals( p2.getEdad(), pRes.getEdad() );
        Assert.assertEquals( p2.getSoltero(), pRes.getSoltero() );
    }
}