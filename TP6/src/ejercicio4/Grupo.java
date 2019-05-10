package ejercicio4;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Grupo
{
    private String nombre;
    private List<Contacto> contactos;

    public Grupo()
    {
        this.contactos = new LinkedList<>();
    }

    public Collection<Contacto> getContactos()
    {
        return contactos;
    }

    public void agregar(Contacto contacto)
    {
        throw new UnsupportedOperationException();
    }

    public void remover(Contacto contacto)
    {
        throw new UnsupportedOperationException();
    }
}
