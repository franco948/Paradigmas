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

    private final String STELLA_LITRO = "Cerveza Stella de litro";
    private final String STELLA_PORRON = "Porron de Cerveza Stella";
    private final String COCA_COLA = "Coca cola de 600 cm3";
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
        Float precio = 25.0f;

        int expectedSize = 5;

        // ACT
        BebidaRepository.altaBebida(bebida, precio);
        Map<String, Float> bebidas = BebidaRepository.devolverBebidas();

        // ASSERT
        Assert.assertEquals( expectedSize, bebidas.size() );

        Assert.assertTrue( bebidas.containsKey(bebida) );
        Assert.assertEquals( precio, bebidas.get(bebida),0);
    }

    @Test
    public void modificarBebida() throws ClassNotFoundException, SQLException {
        // ARRANGE
        String nombreViejo = COCA_COLA;
        String nombreNuevo = "SEVEN UP";
        Float precio = 95.0f;

        int expectedSize = 4;

        // ACT
        BebidaRepository.modificarBebida(nombreViejo, nombreNuevo, precio);
        Map<String, Float> bebidas = BebidaRepository.devolverBebidas();

        // ASSERT
        Assert.assertEquals( expectedSize, bebidas.size() );

        Assert.assertTrue( bebidas.containsKey(nombreNuevo) );
        Assert.assertFalse( bebidas.containsKey(nombreViejo) );
        Assert.assertEquals(precio, bebidas.get(nombreNuevo), 0);
    }

    @Test
    public void borrarBebida() throws ClassNotFoundException, SQLException {
        // ARRANGE
        int expectedSize = 3;
        String bebida = AGUA_SIN_GAS;

        // ACT
        BebidaRepository.borrarBebida(bebida);
        Map<String, Float> bebidas = BebidaRepository.devolverBebidas();

        // ASSERT
        Assert.assertEquals( expectedSize, bebidas.size() );

        Assert.assertFalse( bebidas.containsKey(bebida) );
    }

    @Test
    public void devolverBebidas() throws ClassNotFoundException, SQLException {
        // ARRANGE
        int expectedSize = 4;

        // ACT
        Map<String, Float> bebidas = BebidaRepository.devolverBebidas();

        // ASSERT
        Assert.assertEquals(expectedSize, bebidas.size() );

        Assert.assertTrue( bebidas.containsKey(STELLA_LITRO) );
        Assert.assertTrue( bebidas.containsKey(STELLA_PORRON) );
        Assert.assertTrue( bebidas.containsKey(COCA_COLA) );
        Assert.assertTrue( bebidas.containsKey(AGUA_SIN_GAS) );

        Assert.assertEquals( bebidas.get(STELLA_LITRO), 80, 0);
        Assert.assertEquals( bebidas.get(STELLA_PORRON), 40, 0);
        Assert.assertEquals( bebidas.get(COCA_COLA), 45, 0);
        Assert.assertEquals( bebidas.get(AGUA_SIN_GAS), 30, 0);
    }
}