package ejercicio7;

public class Silla
{
    private Jugador jugador;

    public Silla()
    {
        this.jugador = null;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void vaciar()
    {
        this.jugador = null;
    }

    public boolean ocupada()
    {
        return jugador != null;
    }
}
