package restaurant;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class BebidaRepository {

    public static void altaBebida(String nombre, float precio) throws ClassNotFoundException, SQLException {

        String sql = "INSERT INTO Bebida (beb_nombre, beb_precio) VALUES (?, ?) ";

        Object[] params = new Object[] { nombre, precio };

        Conexion.write(sql, params);

        //throw new UnsupportedOperationException();
    }

    public static void modificarBebida(String nombreViejo, String nombreNuevo, float precio) throws ClassNotFoundException, SQLException {

        String sql = "UPDATE Bebida SET beb_nombre = ?, beb_precio = ? WHERE beb_nombre = ? ";

        Object[] params = new Object[] { nombreNuevo, precio, nombreViejo };

        Conexion.write(sql, params);

        // throw new UnsupportedOperationException();
    }

    public static void borrarBebida(String nombre) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM Bebida WHERE beb_nombre = ? ";

        Object[] params = new Object[] { nombre };

        Conexion.write(sql, params);

        //throw new UnsupportedOperationException();
    }

    public static Map<String, Float> devolverBebidas() throws ClassNotFoundException, SQLException {

        Map<String, Float> bebidas = new HashMap<>();

        String sql = "SELECT * FROM Bebida";

        Conexion.cargarDriver();

        Connection con = Conexion.createConnection();

        Statement statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while ( resultSet.next() ) {
            bebidas.put( resultSet.getString(1), resultSet.getFloat(2) );
        }

        resultSet.close();
        statement.close();
        con.close();

        return bebidas;
    }
}
