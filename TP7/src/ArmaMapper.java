import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArmaMapper implements IMapper<IArma> {
    @Override
    public void insert(IArma entity) {

    }

    @Override
    public void delete(IArma entity) {

    }

    @Override
    public void update(IArma entity) {

    }

    @Override
    public IArma find(IArma entity) {
        String sql = "SELECT * FROM Arma Where id = ?";

        try {
            Connection con = Conexion.createConnection();

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,entity.getId());

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            IArma arma = new Arma(
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getInt(4));

            arma.setId(resultSet.getInt(1));

            resultSet.close();
            statement.close();
            con.close();

            return arma;
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }


        return null;
    }

    @Override
    public ICollection<IArma> all() {
        return null;
    }

    @Override
    public ICollection<IArma> all(int page) {
        return null;
    }

}
