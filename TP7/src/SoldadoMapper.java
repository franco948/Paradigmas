import java.sql.*;

public class SoldadoMapper implements IMapper<Soldado> {

    private int limit = 2;

    @Override
    public void insert(Soldado entity) {
        try {
            String sql =
                    "INSERT INTO Soldado (nombre,apellido,edad,arma_id)" +
                    "VALUES (?,?,?,?)" ;

            Connection con = Conexion.createConnection();

            //PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement statement = con.prepareStatement(sql);

            setPreparedStatement(statement, entity);

            statement.executeUpdate();

            //entity.setId(statement.getGeneratedKeys().getInt(1));

            statement.close();
            con.close();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        finally{

        }
    }

    @Override
    public void delete(Soldado entity) {
        String sql = "DELETE FROM Soldado WHERE Id = ?";

        try {
            Connection con = Conexion.createConnection();

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1,entity.getId());

            statement.executeUpdate();

            statement.close();
            con.close();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void update(Soldado entity) {
        String sql =
                "UPDATE Soldado SET "+
                "nombre = ?, apellido = ?, edad = ?, arma_id = ? " +
                "WHERE id = ?";

        try {
            Connection con = Conexion.createConnection();

            PreparedStatement statement = con.prepareStatement(sql);

            setPreparedStatement(statement, entity);
            statement.setInt(5, entity.getId());

            statement.executeUpdate();

            statement.close();
            con.close();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Soldado find(Soldado entity) {

        String sql = "SELECT * FROM Soldado WHERE id = ?";

        try {
            Connection con = Conexion.createConnection();

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,entity.getId());

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

            Soldado soldado = map(resultSet);

            resultSet.close();
            statement.close();
            con.close();

            return soldado;
        }
        catch (SQLException ex)
        {

        }

        return null;
    }

    @Override
    public ICollection<Soldado> all() {

        String sql =
                "SELECT * FROM Soldado ORDER BY id";

        SmartCollection<Soldado> col = new SmartCollection<>(this);

        mapAll(sql, col);

        return col;
    }


    @Override
    public ICollection<Soldado> all(int page) {

        if(page < 1) throw new IllegalStateException();

        int offset = (page - 1) * limit;

        String sql =
                "SELECT * FROM Soldado ORDER BY id " +
                "LIMIT "+ limit +" OFFSET " + offset;

        SmartCollection<Soldado> col = new SmartCollection<>(this);

        mapAll(sql, col);

        return col;
    }


    private Soldado map(ResultSet resultSet) throws SQLException {
        Soldado soldado = new Soldado(
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getInt(4));

        soldado.setId(resultSet.getInt(1));
        soldado.setArma(new NullArma(resultSet.getInt(5)));

        return soldado;
    }

    private void mapAll(String sql, ICollection<Soldado> collection)
    {
        try {
            Connection con = Conexion.createConnection();

            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next())
            {
                collection.add(map(resultSet));
            }

            resultSet.close();
            statement.close();
            con.close();
        }
        catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void setPreparedStatement(PreparedStatement statement, Soldado entity ) throws SQLException
    {
        statement.setString(1,entity.getNombre());
        statement.setString(2,entity.getApellido());
        statement.setInt(3,entity.getEdad());
        statement.setInt(4, entity.getArma().getId());
    }
}
