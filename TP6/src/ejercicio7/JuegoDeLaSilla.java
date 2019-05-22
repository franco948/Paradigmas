package ejercicio7;

import java.util.LinkedList;
import java.util.List;

public class JuegoDeLaSilla
{
    private List<Jugador> jugadores;
    private List<Silla> sillas;

    public JuegoDeLaSilla(List<Jugador> jugadores)
    {
        // no se puede jugar con menos de dos jugadores
        if (jugadores.size() < 2) throw new IllegalStateException();

        this.jugadores = jugadores;
        inicializarSillas();
    }

    private void inicializarSillas()
    {
        sillas = new LinkedList<>();

        // la cantidad de sillas es una menos a la de jugadores
        for (int i=0; i < jugadores.size() - 1; i++)
        {
            sillas.add(new Silla());
        }
    }

    public void jugar()
    {

    }

    public void nuevaVuelta()
    {
        //

        // quitar silla
    }

    public void imprimir(int ronda, int minutos, Jugador jugador)
    {
        System.out.println("Ronda " + ronda +
                ": La música sonó "+minutos
                +" segundos y cuando paró la música perdió " +
                "\""+jugador.getNombre()+"\"");
    }
}
