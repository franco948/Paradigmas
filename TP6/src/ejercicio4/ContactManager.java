package ejercicio4;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ContactManager
{
    private List<Contacto> contactos;
    private List<Grupo> grupos;

    public ContactManager()
    {
        this.contactos = new LinkedList<>();
        this.grupos = new LinkedList<>();
    }

    public Collection<Contacto> getContactos()
    {
        return contactos;
    }

    public Collection<Grupo> getGrupos()
    {
        return grupos;
    }

    public void agregarContacto(Contacto contacto)
    {
        throw new UnsupportedOperationException();
    }

    public void borrarContacto(Contacto contacto)
    {
        throw new UnsupportedOperationException();
    }

    public void modificarEmail(Contacto contacto, String email)
    {
        throw new UnsupportedOperationException();
    }

    public void crearGrupo(Grupo grupo)
    {
        throw new UnsupportedOperationException();
    }

    public void modificarGrupo(Grupo grupo, String nombre)
    {
        throw new UnsupportedOperationException();
    }
}
