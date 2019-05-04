package ejercicio4;

import ejercicio3.Conexion;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class PersonaRepository {

    public static List<Persona> devolverPersonas() throws ClassNotFoundException, SQLException {

        List<Persona> personas = new LinkedList<>();

        String sql = "SELECT * FROM Persona";

        Conexion.cargarDriver();

        Connection con = Conexion.createConnection();

        Statement statement = con.createStatement();

        ResultSet res = statement.executeQuery(sql);

        while ( res.next() )
        {
            Persona persona = new Persona();

            persona.setNombre( res.getString(1) );
            persona.setApellido( res.getString(2) );
            persona.setEdad( res.getInt(3) );
            persona.setSoltero( res.getBoolean(4) );

            personas.add(persona);
        }

        res.close();
        statement.close();
        con.close();

        return personas;
        // throw new UnsupportedOperationException();
    }
}
