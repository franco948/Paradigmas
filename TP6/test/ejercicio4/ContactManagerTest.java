package ejercicio4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactManagerTest
{
    private ContactManager contactManager;

    private String nombre = "Hernan";
    private String apellido = "Gomez";
    private int telefono = 42404142;
    private String email = "hernan@gmail.com";


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
        // ARRANGE1
        Contacto contacto = new Contacto(nombre, apellido, telefono, email);

        int expectedSize = 1;

        // ACT
        contactManager.agregarContacto(contacto);

        // ASSERT
        Assert.assertEquals(expectedSize, contactManager.getContactos().size());

        contactManager.getContactos().contains(contacto);
    }

    @Test
    public void borrarContacto()
    {
        // ARRANGE
        Contacto contacto = new Contacto(nombre, apellido, telefono, email);

        contactManager.agregarContacto(contacto);

        // ACT
        contactManager.borrarContacto(contacto);

        int expectedSize = 0;

        // ASSERT
        Assert.assertEquals(expectedSize, contactManager.getContactos().size());

        Assert.assertFalse( contactManager.getContactos().contains(contacto) );
    }

    @Test
    public void borrarContacto_PertenecienteAGrupo_EliminaContactoDelGrupo()
    {
        // ARRANGE
        Contacto contacto = new Contacto(nombre, apellido, telefono, email);

        Grupo grupo = new Grupo("Facultad");
        grupo.agregar(contacto);

        contactManager.agregarContacto(contacto);
        // contactManager.crearGrupo(grupo);

        // ACT
        contactManager.borrarContacto(contacto);

        int expectedSize = 0;

        // ASSERT
        Assert.assertEquals(expectedSize, contactManager.getContactos().size());

        // Assert.assertFalse( contactManager.getContactos().contains(contacto) ); // No es necesario, si el tamanio es cero

        Assert.assertEquals(expectedSize, grupo.getContactos().size());
    }

    @Test
    public void modificarEmail()
    {
        // ARRANGE
        Contacto contacto = new Contacto(nombre, apellido, telefono, email);

        contactManager.agregarContacto(contacto);

        String nuevoEmail = "franco94@gmail.com";

        int expectedSize = 1;

        // ACT
        contactManager.modificarEmail(contacto, nuevoEmail);

        // ASSERT
        Assert.assertEquals(expectedSize, contactManager.getContactos().size());

        Assert.assertEquals(nuevoEmail, contactManager.getContactos().get(0).getEmail());
    }

    @Test(expected = IllegalStateException.class)
    public void modificarEmail_ContactoNoEstaEnLaLista_Error()
    {
        // ARRANGE
        Contacto contacto = new Contacto(nombre, apellido, telefono, email);

        // contactManager.agregarContacto(contacto); // contacto no esta mas en la lista

        String nuevoEmail = "franco94@gmail.com";

        int expectedSize = 1;

        // ACT
        contactManager.modificarEmail(contacto, nuevoEmail);
    }

    @Test
    public void crearGrupo()
    {
        // ARRANGE
        Grupo grupo = new Grupo(nombre);

        Contacto contacto = new Contacto(nombre, apellido, telefono, email);

        int expectedSize = 1;

        // ACT
        grupo.agregar(contacto);

        // ASSERT
        Assert.assertEquals(expectedSize, grupo.getContactos().size());

        Assert.assertEquals(contacto, grupo.getContactos().get(0));
    }

    @Test
    public void modificarGrupo()
    {
        // ARRANGE
        Grupo grupo = new Grupo("Facultad");

        contactManager.crearGrupo(grupo);

        String nuevoNombre = "UAI";

        // ACT
        contactManager.modificarGrupo(grupo, nuevoNombre);

        // ASSERT
        Assert.assertEquals(nuevoNombre, contactManager.getGrupos().get(0).getNombre());
    }

    @Test(expected = IllegalStateException.class)
    public void modificarGrupo_GrupoInexistente_Error()
    {
        // ARRANGE
        Grupo grupo = new Grupo("Facultad");

        String nuevoNombre = "UAI";

        // ACT
        contactManager.modificarGrupo(grupo, nuevoNombre);
    }
}