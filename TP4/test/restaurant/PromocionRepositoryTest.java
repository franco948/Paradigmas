package restaurant;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ScriptReader;

import java.sql.SQLException;
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
        String sql = "DROP TABLE Promocion;DROP TABLE Plato_Ingrediente;DROP TABLE Bebida;DROP TABLE Plato; DROP TABLE Ingrediente";
        Conexion.write(sql);
    }

    @Test
    public void devolverPromociones() throws Exception {
        // ARRANGE
        int expectedSize = 2;

        // ACT
        List<String> promociones = PromocionRepository.devolverPromociones();

        // ASSERT
        Assert.assertEquals( expectedSize, promociones.size() );
        Assert.assertTrue( promociones.contains("Mila con ensalada") );
        Assert.assertTrue( promociones.contains("Fideos con bebida") );
    }

    @Test
    public void altaPromocion() throws Exception
    {
        // ARRANGE
        String nombre = "Milanesa con Coca";
        String plato = "Milanesa";
        String bebida = "Coca cola";
        float precio = 250;

        int expectedSize = 3;

        // ACT
        PromocionRepository.altaPromocion(nombre, plato, bebida, precio);
        List<String> promociones = PromocionRepository.devolverPromociones();

        // ASSERT
        Assert.assertEquals( expectedSize, promociones.size() );

        Assert.assertTrue( promociones.contains(nombre) );
    }

    @Test
    public void eliminarPromocion() throws Exception
    {
        // ARRANGE
        String nombre = "Fideos con bebida";

        int expectedSize = 1;

        // ACT
        PromocionRepository.eliminarPromocion( nombre );
        List<String> promociones = PromocionRepository.devolverPromociones();

        // ASSERT
        Assert.assertEquals( expectedSize, promociones.size() );

        Assert.assertFalse( promociones.contains(nombre) );
    }

    @Test
    public void modificarPromocion() throws Exception
    {
        // ARRANGE
        String nombreViejo = "Fideos con bebida";
        String nombreNuevo = "Ensalada con Coca";
        String plato = "EnsaladaMixta";
        String bebida = "Coca cola";
        float precio = 250;

        int expectedSize = 2;

        // ACT
        PromocionRepository.modificarPromocion(nombreViejo, nombreNuevo, plato, bebida, precio);
        List<String> promociones = PromocionRepository.devolverPromociones();

        // ASSERT
        Assert.assertEquals( expectedSize, promociones.size() );
        Assert.assertTrue( promociones.contains(nombreNuevo) );
        Assert.assertFalse( promociones.contains(nombreViejo) );
    }
}