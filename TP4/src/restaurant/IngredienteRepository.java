package restaurant;

import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IngredienteRepository {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //cargarDriver();

        altaIngrediente(null, null);
    }

    public static void altaIngrediente(String nombre, String tipo) throws SQLException, ClassNotFoundException {

        String sql =
                        "INSERT INTO Ingrediente (ing_nombre, ing_tipo)" +
                        "VALUES ('" + nombre + "', '" + tipo + "')";

        //Object[] params = new Object[] { nombre, tipo };

        Conexion.write(sql);
    }

    public static void borrarIngrediente(String nombre) throws ClassNotFoundException, SQLException {

        String sql =
                "DELETE FROM Ingrediente " +
                "WHERE ing_nombre = '" + nombre + "';";

        Conexion.write(sql);

        //throw new UnsupportedOperationException();
    }

    public static void modificarIngrediente(String nombreViejo, String nombreNuevo, String tipoNuevo)
            throws ClassNotFoundException, SQLException {

        String sql =
                "UPDATE Ingrediente SET " +
                "ing_nombre = '" + nombreNuevo + "', ing_tipo = '" + tipoNuevo + "' " +
                "WHERE ing_nombre = '" + nombreViejo + "'";

        //Object[] params = new Object[] { nombreNuevo, tipoNuevo, nombreViejo };

        Conexion.write(sql);

        //throw new UnsupportedOperationException();
    }

    public static List<String> devolverIngredientes() throws ClassNotFoundException, SQLException {

        List<String> ingredientes = new LinkedList<>();

        String sql = "SELECT ing_nombre FROM Ingrediente";

        Conexion.cargarDriver();

        Connection con = Conexion.createConnection();

        Statement statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while ( resultSet.next() ) {
            String ingrediente = resultSet.getString("ing_nombre");
            ingredientes.add(ingrediente);
        }

        resultSet.close();
        statement.close();
        con.close();

        return ingredientes;
        //throw new UnsupportedOperationException();
    }

    public static List<String> devolverVerduras() throws ClassNotFoundException, SQLException {

        List<String> ingredientes = new LinkedList<>();

        String sql = "SELECT ing_nombre FROM Ingrediente WHERE ing_tipo = 'Verdura'";

        Conexion.cargarDriver();

        Connection con = Conexion.createConnection();

        Statement statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while ( resultSet.next() ) {
            String verduras = resultSet.getString("ing_nombre");
            ingredientes.add(verduras);
        }

        resultSet.close();
        statement.close();
        con.close();

        return ingredientes;
        //throw new UnsupportedOperationException();
    }

}
