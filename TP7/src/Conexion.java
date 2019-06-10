import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    public static void initialize(){
        try {
            Class.forName(DB_DRIVER);
        }
        catch (ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                DB_CONNECTION,
                DB_USER,
                DB_PASSWORD);
    }
}
