package ejercicio4;

import java.util.LinkedList;
import java.util.List;

public class Contacto
{
    private String nombre;
    private String apellido;
    private int telefono;
    private String email;

    private List<Grupo> grupos;

    public Contacto(String nombre, String apellido, int telefono, String email)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;

        grupos = new LinkedList<>();
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void attach(Grupo grupo)
    {
        grupos.add(grupo);
    }

    public void eliminar()
    {
        for (Grupo g : grupos)
        {
            g.remover(this);
        }
    }
}
