package restaurant;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.sql.*;
import java.util.*;

public class BebidaRepository {


    public static void altaBebida(String nombre, int tamaño, float precio) throws ClassNotFoundException, SQLException {

        String sql = "INSERT INTO Bebida (beb_nombre, beb_tamaño, beb_precio) VALUES (?, ?, ?) ";

        Object[] params = new Object[] { nombre, tamaño, precio };

        Conexion.write(sql, params);

        //throw new UnsupportedOperationException();
    }

    public static void modificarBebida(String nombreViejo, String nombreNuevo, int tamaño, float precio) throws ClassNotFoundException, SQLException {

        String sql = "UPDATE Bebida SET beb_nombre = ?, beb_tamaño = ?, beb_precio = ? WHERE beb_nombre = ? ";

        Object[] params = new Object[] { nombreNuevo, tamaño, precio, nombreViejo };

        Conexion.write(sql, params);

        // throw new UnsupportedOperationException();
    }

    public static void borrarBebida(String nombre) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM Bebida WHERE beb_nombre = ? ";

        Object[] params = new Object[] { nombre };

        Conexion.write(sql, params);

        //throw new UnsupportedOperationException();
    }

    public static List<String> devolverBebidas() throws ClassNotFoundException, SQLException {

        List<String> bebidas = new LinkedList<>();

        String sql = "SELECT * FROM Bebida";

        Conexion.cargarDriver();

        Connection con = Conexion.createConnection();

        Statement statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while ( resultSet.next() ) {

            bebidas.add( resultSet.getString(1) );
        }

        resultSet.close();
        statement.close();
        con.close();

        return bebidas;
    }
}
