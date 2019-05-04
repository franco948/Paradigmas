package ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public static void write (String sql, List<Object> params, Connection con) throws ClassNotFoundException, SQLException {
        Conexion.cargarDriver();

        //Connection con = Conexion.createConnection();

        PreparedStatement statement = con.prepareStatement(sql);

        if ( params != null )
        {
            int i = 1;

            for (Object val : params) {
                statement.setObject(i++, val);
            }
        }

        statement.executeUpdate();

        statement.close();
        //con.close();
    }
}
