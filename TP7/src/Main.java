import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args)
    {
        Conexion.initialize();
        createTable();
        setData();

        SoldadoMapper soldadoMapper = new SoldadoMapper();

        ICollection<Soldado> soldados = soldadoMapper.all(1);
        soldados.get(3);
        soldados.get(3);
        //soldados.get(4); // deberia tirar error


        Soldado soldado = new Soldado("Ezequiel", "Lopez", 30);
        soldado.setArma(soldados.get(1).getArma());

        soldadoMapper.insert(soldado);

        soldados.get(4);

        Soldado s1 =soldados.get(1);
        Soldado s2 =soldados.get(2);

        s1.getArma().disparar(s2);
        s1.setArma(new ArmaMapper().find(s1.getArma()));
        s1.getArma().disparar(s2);

        s1.setNombre("Franco");
        s1.setApellido("Palermo");
        s1.setEdad(24);


        soldadoMapper.update(s1);
        soldadoMapper.delete(s1);

        soldados.remove(s1);



        dropTable();
    }

    public static void setData()
    {
        String sql =
        "INSERT INTO Arma (nombre,daño, alcance) VALUES ('Rifle',10, 500);" +
        "INSERT INTO Arma (nombre,daño, alcance) VALUES ('Bazooka',100, 1000);" +
        "INSERT INTO Arma (nombre,daño, alcance) VALUES ('Cuchillo',5, 2);" +
        "INSERT INTO Arma (nombre,daño, alcance) VALUES ('Laser',500, 100);";

        sql +=
                "INSERT INTO Soldado (nombre, apellido,edad,arma_id) VALUES ('Hernan','Fernandez', 30,1);" +
                "INSERT INTO Soldado (nombre, apellido,edad,arma_id) VALUES ('Kevin','Gomez', 25,2);" +
                "INSERT INTO Soldado (nombre, apellido,edad,arma_id) VALUES ('Leandro','Lopez', 40,3);" +
                "INSERT INTO Soldado (nombre, apellido,edad,arma_id) VALUES ('Martin','Figueroa', 23,4);";

        try {
            Connection con = Conexion.createConnection();

            Statement statement = con.createStatement();
            statement.executeUpdate(sql);

            statement.close();
            con.close();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static void createTable()
    {

        String sql =
                "CREATE TABLE Arma (" +
                        "id int identity(1,1) primary key," +
                        "nombre varchar(30) not null," +
                        "daño int not null," +
                        "alcance int not null" +
                        ");";
        sql +=
                "CREATE TABLE Soldado (" +
                "id int identity(1,1) primary key," +
                "nombre varchar(30) not null," +
                "apellido varchar(30) not null," +
                "edad int not null," +
                "arma_id int null" +
                ")";

        try {
            Connection con = Conexion.createConnection();

            Statement statement = con.createStatement();
            statement.executeUpdate(sql);

            statement.close();
            con.close();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public static void dropTable()
    {
        String sql ="DROP TABLE Soldado; DROP TABLE Arma";

        try{
            Connection con = Conexion.createConnection();

            Statement statement = con.createStatement();

            statement.executeUpdate(sql);

            statement.close();
            con.close();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
