package ejercicio4;

import ejercicio3.Conexion;
import org.h2.util.ScriptReader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class PersonaRepositoryTest {

    @Before
    public void setUp() throws Exception {
        Connection con = Conexion.createConnection();

        ScriptReader script = new ScriptReader(new FileReader("persona.sql"));
        String sql = script.readStatement();
        Conexion.write(sql, null, con);
        script.close();

        sql = "INSERT INTO Persona (per_nombre, per_apellido, per_edad, per_soltero) VALUES ('Martin', 'Figueroa', 24, 0);" +
              "INSERT INTO Persona (per_nombre, per_apellido, per_edad, per_soltero) VALUES ('Hernan', 'Gomez', 32, 1);";

        con.close();
        con = Conexion.createConnection();

        Conexion.write(sql, null, con);
        con.close();
    }

    @After
    public void tearDown() throws Exception {
        Connection con = Conexion.createConnection();
        String sql = "DROP TABLE Persona";
        Conexion.write(sql, null, con);
        con.close();
    }

    @Test
    public void devolverPersonas() throws ClassNotFoundException, SQLException {
        // ARRANGE
        int expectedSize = 2;
        String nombre = "Martin";
        String apellido = "Figueroa";
        int edad = 24;
        boolean soltero = false;

        // ACT
        List<Persona> personas = PersonaRepository.devolverPersonas();

        // ASSERT
        Assert.assertEquals( expectedSize, personas.size() );

        Persona p1 = personas.get(0);
        Assert.assertEquals( nombre, p1.getNombre() );
        Assert.assertEquals( apellido, p1.getApellido() );
        Assert.assertEquals( edad, p1.getEdad() );
        Assert.assertEquals( soltero, p1.getSoltero() );
    }
}