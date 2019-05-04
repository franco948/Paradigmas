package restaurant;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Conexion {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    public static void cargarDriver() throws ClassNotFoundException {
        Class.forName(DB_DRIVER);
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                DB_CONNECTION,
                DB_USER,
                DB_PASSWORD);
    }

    public static void write(String sql) throws ClassNotFoundException, SQLException {
        cargarDriver();

        Connection con = createConnection();

        Statement statement = con.createStatement();

        try {
            statement.executeUpdate(sql);
        }
        catch (SQLException ex) {
            throw ex;
        }
        finally {
            statement.close();
            con.close();
        }
    }

    public static void write(String sql, Object[] params)  throws ClassNotFoundException, SQLException {
        cargarDriver();

        Connection con = DriverManager.getConnection(
                DB_CONNECTION,
                DB_USER,
                DB_PASSWORD);

        PreparedStatement statement = con.prepareStatement(sql);

        try {
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    // TODO: probar con i en vez de i + 1, DA ERROR usando i, no acepta indice 0
                    set(statement, i + 1, params[i]);
                }
            }

            statement.executeUpdate();
        }
        catch (SQLException ex)  {
            throw ex;
        }
        finally {
            statement.close();
            con.close();
        }
    }

    public static List<String> read(String sql, Object[] params) throws ClassNotFoundException, SQLException
    {
        List<String> values = new LinkedList<>();

        cargarDriver();

        Connection con = createConnection();

        PreparedStatement statement = con.prepareStatement(sql);

        if ( params != null )
        {
            for (int i = 0; i < params.length; i++)
            {
                set(statement, i + 1, params[i]);
            }
        }

        ResultSet resultSet = statement.executeQuery();

        while ( resultSet.next() )
        {
            values.add( resultSet.getString(1) );
        }

        resultSet.close();
        statement.close();
        con.close();

        return values;
    }

    /*
    public static ResultSet read(String sql) throws ClassNotFoundException, SQLException {
        cargarDriver();

        Connection con = DriverManager.getConnection(
                DB_CONNECTION,
                DB_USER,
                DB_PASSWORD);

        Statement statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        return resultSet;
    }
*/
    private static void set(PreparedStatement statement, int pos, Object value) throws SQLException {
        statement.setObject(pos, value);
    }
    /*
    private static void set(PreparedStatement statement, int pos, String value) throws SQLException {
        statement.setString(pos, value);
    }

    private static void set(PreparedStatement statement, int pos, float value) throws SQLException {
        statement.setFloat(pos, value);
    }*/
}
