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

    public List<Contacto> getContactos()
    {
        return contactos;
    }

    public List<Grupo> getGrupos()
    {
        return grupos;
    }

    public void agregarContacto(Contacto contacto)
    {
        contactos.add(contacto);
    }

    public void borrarContacto(Contacto contacto)
    {
        // TODO: verificar que exista y sino lanzar error

        for (Contacto c : contactos)
        {
            if ( contacto.equals(c) )
            {
                c.eliminar();
            }
        }

        contactos.remove(contacto);
    }

    public void modificarEmail(Contacto contacto, String email)
    {
        if ( !contactos.contains(contacto) ) throw new IllegalStateException();

        contacto.setEmail(email);
    }

    public void crearGrupo(Grupo grupo)
    {
        grupos.add(grupo);
    }

    public void modificarGrupo(Grupo grupo, String nombre)
    {
        if ( !grupos.contains(grupo) ) throw new IllegalStateException();

        grupo.setNombre(nombre);
    }
}
