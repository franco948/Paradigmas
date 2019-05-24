package ejercicio7;

public class Jugador
{
    private String nombre;
    private Silla silla;

    public Jugador(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setSilla(Silla silla) {
        this.silla = silla;
    }

    public boolean sentado()
    {
        return silla != null;
    }

    public void levantarse()
    {
        silla.removerJugador();
        this.silla = null;
    }
}
