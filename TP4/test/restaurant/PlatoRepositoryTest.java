package restaurant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ScriptReader;

import java.io.FileReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PlatoRepositoryTest {

    private final String MILANESA = "Milanesa";
    private final String ENSALADA_MIXTA = "EnsaladaMixta";
    private final String FIDEOS_CON_SALSA = "FideosConSalsa";

    @Before
    public void setUp() throws Exception {
        ScriptReader reader = new ScriptReader("ingrediente.sql");
        String sql = reader.readStatement();
        reader.close();
        Conexion.write(sql);

        reader = new ScriptReader("plato.sql");
        Conexion.write(reader.readStatement());
        reader.close();
    }

    @After
    public void tearDown() throws Exception {
        String sql = "DROP TABLE Plato_Ingrediente; DROP TABLE Plato; DROP TABLE Ingrediente";
        Conexion.write(sql);
    }

    @Test
    public void altaPlato() throws ClassNotFoundException, SQLException {
        // ARRANGE
        String nombre = "Estofado";
        String ing1 = "CarneParaMilanesa";
        String ing2 = "Salsa";
        float precio = 100;
        int expectedSize = 4;

        // ACT
        PlatoRepository.altaPlato(nombre, new String[] { ing1, ing2 }, precio);
        Map<String, Float> platos = PlatoRepository.devolverPlatos();
        List<String> ingredientes = PlatoRepository.devolverIngredientes(nombre);

        // ASSERT
        Assert.assertEquals(expectedSize, platos.size());

        Assert.assertTrue( platos.containsKey(nombre) );
        Assert.assertEquals( precio, platos.get(nombre), 0);

        // TODO: testear que devuelva los ingredientes, pero primedo testear el metodo devolverIngredientes
        Assert.assertEquals(2, ingredientes.size());

        Assert.assertTrue( ingredientes.contains(ing1) );
        Assert.assertTrue( ingredientes.contains(ing2) );
    }

    @Test
    public void devolverPlatos() throws ClassNotFoundException, SQLException {
        // ARRANGE
        int expectedSize = 3;

        // ACT
        Map<String, Float> platos = PlatoRepository.devolverPlatos();

        // ASSERT
        Assert.assertEquals(expectedSize, platos.size());

        Assert.assertTrue( platos.containsKey(MILANESA) );
        Assert.assertEquals( 70, platos.get(MILANESA), 0);

        Assert.assertTrue( platos.containsKey(FIDEOS_CON_SALSA) );
        Assert.assertEquals( 60, platos.get(FIDEOS_CON_SALSA), 0);

        Assert.assertTrue( platos.containsKey(ENSALADA_MIXTA) );
        Assert.assertEquals( 50, platos.get(ENSALADA_MIXTA), 0);
    }

    @Test
    public void devolverIngredientes() throws ClassNotFoundException, SQLException {
        // ARRANGE
        int expectedSize = 2;

        // ACT
        List<String> ingredientes = PlatoRepository.devolverIngredientes(MILANESA);

        // ASSERT
        Assert.assertEquals( expectedSize , ingredientes.size() );

        Assert.assertTrue( ingredientes.contains("CarneParaMilanesa") );
        Assert.assertTrue( ingredientes.contains("PanRallado") );
    }

    @Test
    public void borrarPlato() throws ClassNotFoundException, SQLException {
        // ARRANGE
        int expectedSize = 2;

        // ACT
        PlatoRepository.borrarPlato(ENSALADA_MIXTA);
        Map<String, Float> platos = PlatoRepository.devolverPlatos();
        List<String> ingredientes = PlatoRepository.devolverIngredientes(ENSALADA_MIXTA);

        // ASSERT
        Assert.assertEquals( expectedSize, platos.size() );

        Assert.assertTrue( platos.containsKey(MILANESA) );
        Assert.assertTrue( platos.containsKey(FIDEOS_CON_SALSA) );

        Assert.assertFalse( platos.containsKey(ENSALADA_MIXTA) );

        Assert.assertEquals(0, ingredientes.size() );
    }

    @Test
    public void modificarPlato() throws ClassNotFoundException, SQLException {
        // ARRANGE
        String nombreViejo = ENSALADA_MIXTA;
        String nombreNuevo = "EnsaladaRusa";
        float precio = 150;

        // ACT
        PlatoRepository.modificarPlato(nombreViejo, nombreNuevo, precio);
        Map<String, Float> platos = PlatoRepository.devolverPlatos();
        List<String> ingredientes = PlatoRepository.devolverIngredientes(nombreNuevo);

        // ASSERT
        Assert.assertEquals(3, platos.size() );

        Assert.assertTrue( platos.containsKey(nombreNuevo) );
        Assert.assertFalse( platos.containsKey(nombreViejo) );

        Assert.assertEquals( precio, platos.get(nombreNuevo), 0);

        Assert.assertEquals( 3, ingredientes.size() );
        Assert.assertTrue( ingredientes.contains("Lechuga") );
        Assert.assertTrue( ingredientes.contains("Tomate") );
        Assert.assertTrue( ingredientes.contains("Cebolla") );
    }
}