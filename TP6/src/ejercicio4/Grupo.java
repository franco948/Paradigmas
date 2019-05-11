package ejercicio4;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Grupo
{
    private String nombre;
    private List<Contacto> contactos;

    public Grupo(String nombre)
    {
        this.nombre = nombre;
        this.contactos = new LinkedList<>();
    }

    public List<Contacto> getContactos()
    {
        return contactos;
    }

    public void agregar(Contacto contacto)
    {
        contacto.attach(this);

        contactos.add(contacto);
    }

    public void remover(Contacto contacto)
    {
        contactos.remove(contacto);
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}
