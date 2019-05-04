package restaurant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ScriptReader;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BebidaRepositoryTest {

    private final String STELLA_LITRO = "Cerveza Stella";
    private final String STELLA_PORRON = "Porron Cerveza Stella";
    private final String COCA_COLA = "Coca cola";
    private final String AGUA_SIN_GAS = "Agua sin gas";

    @Before
    public void setUp() throws Exception {
        ScriptReader reader = new ScriptReader("bebida.sql");
        String sql = reader.readStatement();
        Conexion.write(sql);
        reader.close();
    }

    @After
    public void tearDown() throws Exception {
        String sql = "DROP TABLE Bebida";
        Conexion.write(sql);
    }

    @Test
    public void altaBebida() throws ClassNotFoundException, SQLException {
        // ARRANGE
        String bebida = "PEPSI";
        int tam = 1500;
        Float precio = 25.0f;

        int expectedSize = 5;

        // ACT
        BebidaRepository.altaBebida(bebida, tam, precio);
        List<String> bebidas = BebidaRepository.devolverBebidas();

        // ASSERT
        Assert.assertEquals( expectedSize, bebidas.size() );

        Assert.assertTrue( bebidas.contains(bebida) );
    }

    @Test
    public void modificarBebida() throws ClassNotFoundException, SQLException {
        // ARRANGE
        String nombreViejo = COCA_COLA;
        String nombreNuevo = "SEVEN UP";
        int tam = 750;
        Float precio = 95.0f;

        int expectedSize = 4;

        // ACT
        BebidaRepository.modificarBebida(nombreViejo, nombreNuevo, tam, precio);
        List<String> bebidas = BebidaRepository.devolverBebidas();

        // ASSERT
        Assert.assertEquals( expectedSize, bebidas.size() );

        Assert.assertTrue( bebidas.contains(nombreNuevo) );
        Assert.assertFalse( bebidas.contains(nombreViejo) );
    }

    @Test
    public void borrarBebida() throws ClassNotFoundException, SQLException {
        // ARRANGE
        int expectedSize = 3;
        String bebida = AGUA_SIN_GAS;

        // ACT
        BebidaRepository.borrarBebida(bebida);
        List<String> bebidas = BebidaRepository.devolverBebidas();

        // ASSERT
        Assert.assertEquals( expectedSize, bebidas.size() );

        Assert.assertFalse( bebidas.contains(bebida) );
    }

    @Test
    public void devolverBebidas() throws ClassNotFoundException, SQLException {
        // ARRANGE
        int expectedSize = 4;

        // ACT
        List<String> bebidas = BebidaRepository.devolverBebidas();

        // ASSERT
        Assert.assertEquals(expectedSize, bebidas.size() );

        Assert.assertTrue( bebidas.contains(STELLA_LITRO) );
        Assert.assertTrue( bebidas.contains(STELLA_PORRON) );
        Assert.assertTrue( bebidas.contains(COCA_COLA) );
        Assert.assertTrue( bebidas.contains(AGUA_SIN_GAS) );
    }
}