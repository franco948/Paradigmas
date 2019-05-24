package ejercicio7;

import java.util.List;
import java.util.Random;

public class Silla
{
    private Jugador jugador;

    public Silla()
    {
        this.jugador = null;
    }

    /*public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }*/

    public void removerJugador()
    {
        this.jugador = null;
    }

    public void sentarJugador(List<Jugador> jugadores)
    {
        Random r = new Random();
        //int index = (int)Math.random() * jugadores.size();

        boolean pudoSentarse = false;

        while (!pudoSentarse)
        {
            int index = r.nextInt(jugadores.size());

            Jugador jugador = jugadores.get(index);

            if(!jugador.sentado())
            {
                jugador.setSilla(this);
                this.jugador = jugador;
                pudoSentarse = true;
            }

        }


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
