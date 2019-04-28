package restaurant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class IngredienteRepositoryTest {

    @Before
    public void setUp() throws Exception {
        String sql =
                "CREATE TABLE Ingrediente (" +
                        "ing_nombre varchar(30) PRIMARY KEY NOT NULL," +
                        "ing_tipo varchar(30) NOT NULL );";

        sql +=
                "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Papa', 'Verdura');" +
                "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Milanesa', 'Carne');" +
                "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Pan', 'Otros');" +
                "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Huevo', 'Otros');" +
                "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Lechuga', 'Verdura');" +
                "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Tomate', 'Verdura');" +
                "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Fideos', 'Pasta');" +
                "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Salsa', 'Otros');" +
                "INSERT INTO Ingrediente (ing_nombre, ing_tipo) VALUES ('Cebolla', 'Verdura');";

        Conexion.write(sql);
    }

    @After
    public void tearDown() throws Exception {
        String sql = "DROP TABLE Ingrediente";

        Conexion.write(sql);
    }

    @Test
    public void altaIngrediente() throws ClassNotFoundException, SQLException {
        // ARRANGE
        String nombre = "Manzana";
        String tipo = "Fruta";

        // ACT
        IngredienteRepository.altaIngrediente(nombre, tipo);
        List<String> ingredientes = IngredienteRepository.devolverIngredientes();

        // ASSERT
        Assert.assertEquals(10, ingredientes.size());
        Assert.assertTrue(ingredientes.contains(nombre));
    }

    @Test
    public void borrarIngrediente() throws ClassNotFoundException, SQLException {
        // ARRANGE
        String nombre = "Papa";

        // ACT
        IngredienteRepository.borrarIngrediente(nombre);
        List<String> ingredientes = IngredienteRepository.devolverIngredientes();

        // ASSERT
        Assert.assertEquals(8, ingredientes.size());
        Assert.assertFalse( ingredientes.contains(nombre) );
    }

    @Test
    public void modificarIngrediente() throws ClassNotFoundException, SQLException {
        // ARRANGE
        String nombreViejo = "Papa";
        String nombreNuevo = "Banana";
        String nuevoTipo = "Fruta";

        // ACT
        IngredienteRepository.modificarIngrediente(nombreViejo, nombreNuevo, nuevoTipo);
        List<String> ingredientes = IngredienteRepository.devolverIngredientes();

        // ASSERT
        Assert.assertEquals(9, ingredientes.size());
        Assert.assertTrue( ingredientes.contains(nombreNuevo) );
        Assert.assertFalse( ingredientes.contains(nombreViejo) );
    }

    @Test
    public void devolverVerduras() throws ClassNotFoundException, SQLException {
        // ACT
        List<String> verduras = IngredienteRepository.devolverVerduras();

        // ASSERT
        Assert.assertEquals(4, verduras.size());
        Assert.assertTrue( verduras.contains("Papa") );
        Assert.assertTrue( verduras.contains("Tomate") );
        Assert.assertTrue( verduras.contains("Lechuga") );
        Assert.assertTrue( verduras.contains("Cebolla") );
    }
}