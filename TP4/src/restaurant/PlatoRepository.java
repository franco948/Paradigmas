package restaurant;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.CheckedOutputStream;

public class PlatoRepository {

    public static void altaPlato(String nombre, String[] ingredientes, float precio) throws ClassNotFoundException, SQLException {

        String sql =
                "INSERT INTO Plato (pla_nombre, pla_precio) " +
                "VALUES (?, ?)";

        Conexion.write(sql, new Object[] { nombre, precio } );

        sql =
                "INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) " +
                "VALUES (?, ?)";

        for (String ing : ingredientes) {
            Conexion.write(sql, new Object[] { nombre, ing } );
        }

        //throw new UnsupportedOperationException();
    }

    public static void borrarPlato(String nombre) throws ClassNotFoundException, SQLException {

        Object[] params = new Object[] { nombre };

        String sql = "DELETE FROM Plato_Ingrediente WHERE pla_nombre = ? ";

        Conexion.write(sql, params );

        sql = "DELETE FROM Plato WHERE pla_nombre = ? ";

        Conexion.write(sql, params);

        // throw new UnsupportedOperationException();
    }

    public static void modificarPlato(String nombreViejo, String nombreNuevo, float precio) throws ClassNotFoundException, SQLException {

        String sql = "UPDATE Plato_Ingrediente SET pla_nombre = ? WHERE pla_nombre = ? ";

        Object[] params = new Object[] { nombreNuevo, nombreViejo };

        Conexion.write(sql, params);

        sql = "UPDATE Plato SET pla_nombre = ?, pla_precio = ? WHERE pla_nombre = ? ";

        params = new Object[] { nombreNuevo, precio, nombreViejo };

        Conexion.write(sql, params);

        // throw new UnsupportedOperationException();
    }

    public static Map<String, Float> devolverPlatos() throws ClassNotFoundException, SQLException {

        Map<String, Float> platos = new HashMap<>();

        String sql = "SELECT * FROM Plato";

        Conexion.cargarDriver();

        Connection con = Conexion.createConnection();

        Statement statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while ( resultSet.next() ) {
            platos.put(resultSet.getString(1), resultSet.getFloat(2));
        }

        resultSet.close();
        statement.close();
        con.close();

        return platos;
    }

    public static List<String> devolverIngredientes(String plato) throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM Plato_Ingrediente WHERE pla_nombre = ? ";

        List<String> ingredientes = new LinkedList<>();

        Conexion.cargarDriver();

        Connection con = Conexion.createConnection();

        PreparedStatement statement = con.prepareStatement(sql);

        statement.setString(1, plato);

        ResultSet resultSet = statement.executeQuery();

        while ( resultSet.next() ) {
            ingredientes.add( resultSet.getString(2) );
        }

        resultSet.close();
        statement.close();
        con.close();

        return ingredientes;
        // throw new UnsupportedOperationException();
    }
}
