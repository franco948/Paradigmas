package restaurant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PromocionRepository {

    public static void altaPromocion(String nombre, String plato, String bebida, float precio) throws ClassNotFoundException, SQLException
    {
        String sql =
                "INSERT INTO Promocion (pro_nombre, pro_plato, pro_bebida, pro_precio) " +
                "VALUES (?, ?, ?, ?)";

        Object[] params = new Object[] { nombre, plato, bebida, precio };

        Conexion.write(sql, params);
    }

    public static void modificarPromocion(String nombreViejo, String nombreNuevo, String plato, String bebida, float precio) throws ClassNotFoundException, SQLException
    {
        String sql =
                "UPDATE Promocion " +
                "SET pro_nombre = ?, pro_plato = ?, pro_bebida = ?, pro_precio = ? " +
                "WHERE pro_nombre = ?";

        Object[] params = new Object[] { nombreNuevo, plato, bebida, precio, nombreViejo };

        Conexion.write(sql, params);
    }

    public static void eliminarPromocion(String nombre) throws ClassNotFoundException, SQLException
    {
        String sql = "DELETE FROM Promocion WHERE pro_nombre = ? ";

        Object[] params = new Object[] { nombre };

        Conexion.write(sql, params);
    }

    public static List<String> devolverPromociones() throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM Promocion";

        return Conexion.read(sql, null);
        // throw new UnsupportedOperationException();
    }
}
