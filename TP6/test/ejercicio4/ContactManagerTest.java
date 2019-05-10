package ejercicio4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactManagerTest {

    private ContactManager contactManager;

    @Before
    public void setUp() throws Exception
    {
        contactManager = new ContactManager();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void agregarContacto()
    {
        // ARRANGE
        String nombre = "Hernan";
        String apellido = "Gomez";
        int telefono = 42404142;
        String email = "hernan@gmail.com";

        Contacto contacto = new Contacto(nombre, apellido, telefono, email);

        int expectedSize = 1;

        // ACT
        contactManager.agregarContacto(contacto);

        // ASSERT
        Assert.assertEquals(expectedSize, contactManager.getContactos().size());
    }

    @Test
    public void borrarContacto() {
    }

    @Test
    public void modificarEmail() {
    }

    @Test
    public void crearGrupo() {
    }

    @Test
    public void modificarGrupo() {
    }
}