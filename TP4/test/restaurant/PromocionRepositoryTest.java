package restaurant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import restaurant.entidades.Promocion;
import util.ScriptReader;

import java.util.List;

import static org.junit.Assert.*;

public class PromocionRepositoryTest {

    @Before
    public void setUp() throws Exception {
        ScriptReader reader = new ScriptReader("ingrediente.sql");
        Conexion.write(reader.readStatement());
        reader.close();

        reader = new ScriptReader("plato.sql");
        Conexion.write(reader.readStatement());
        reader.close();

        reader = new ScriptReader("bebida.sql");
        Conexion.write(reader.readStatement());
        reader.close();

        reader = new ScriptReader("promocion.sql");
        Conexion.write(reader.readStatement());
        reader.close();
    }

    @After
    public void tearDown() throws Exception {
        String sql = "DROP TABLE Promocion; DROP TABLE Bebida; DROP TABLE Plato; DROP TABLE Ingrediente";
    }

    @Test
    public void devolverPromociones() {
        // ARRANGE
        int expectedSize = 2;

        // ACT
        List<String> promociones = PromocionRepository.devolverPromociones();

        // ASSERT
        Assert.assertEquals(expectedSize, promociones.size());
        Assert.assertTrue()
    }
}