package restaurant;

import org.h2.util.ScriptReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;

import static org.junit.Assert.*;

public class PlatoRepositoryTest {

    @Before
    public void setUp() throws Exception {
        String sql =
                "CREATE TABLE Ingrediente (" +
                        "ing_nombre varchar(30) PRIMARY KEY NOT NULL," +
                        "ing_tipo varchar(30) NOT NULL );";

        sql +=
                "CREATE TABLE Plato (" +
                        "pla_nombre varchar(30) PRIMARY KEY NOT NULL," +
                        "pla_precio float NOT NULL );";

        sql +=
                "CREATE TABLE Plato_Ingrediente (" +
                        "pla_nombre varchar(30) NOT NULL," +
                        "ing_nombre varchar(30) NOT NULL," +
                        "PRIMARY KEY (pla_nombre, ing_nombre);";

        sql +=
                "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Papa', 'Verdura');" +
                        "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('CarneParaMilanesa', 'Carne');" +
                        "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('PanRallado', 'Otros');" +
                        "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Huevo', 'Otros');" +
                        "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Lechuga', 'Verdura');" +
                        "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Tomate', 'Verdura');" +
                        "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Fideos', 'Pasta');" +
                        "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Salsa', 'Otros');" +
                        "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Cebolla', 'Verdura');";

        sql +=
                "INSERT INTO Plato (pla_nombre, pla_precio) VALUES ('Milanesa', 70);" +
                "INSERT INTO Plato (pla_nombre, pla_precio) VALUES ('EnsaladaMixta', 50);" +
                "INSERT INTO Plato (pla_nombre, pla_precio) VALUES ('FideosConSalsa', 60);";

        sql +=
                "INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('Milanesa', 'CarneParaMilanesa');" +
                "INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('Milanesa', 'PanRallado');" +
                "INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('EnsaladaMixa', 'Lechuga');" +
                "INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('EnsaladaMixa', 'Tomate');" +
                "INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('EnsaladaMixa', 'Cebolla');" +
                "INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('FideosConSalsa', 'Fideos');" +
                "INSERT INTO Plato_Ingrediente (pla_nombre, ing_nombre) VALUES ('FideosConSalsa', 'Salsa');";

        Conexion.write(sql);
        String statement = new ScriptReader(new FileReader("datos.sql")).readStatement();
        Conexion.write(statement);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void altaPlato() {
        // ARRANGE
        System.out.println("OK");
        //String nombre = ""

        // ACT

        // ASSERT
    }
}