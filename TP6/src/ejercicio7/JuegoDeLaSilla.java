package ejercicio7;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class JuegoDeLaSilla
{
    private int ronda = 0;
    private int max = 1;
    private int min = 1;
    private List<Jugador> jugadores;
    private List<Silla> sillas;

    public static void main(String[] args) throws InterruptedException
    {
        List<Jugador> jugadores = new LinkedList<>();
        jugadores.add(new Jugador("Dario"));
        jugadores.add(new Jugador("Hernan"));
        jugadores.add(new Jugador("Alejandro"));
        jugadores.add(new Jugador("Julian"));
        jugadores.add(new Jugador("Mariana"));

        new JuegoDeLaSilla(1).jugar(jugadores);


        jugadores = new LinkedList<>();
        jugadores.add(new Jugador("Dario"));
        jugadores.add(new Jugador("Hernan"));
        jugadores.add(new Jugador("Alejandro"));
        jugadores.add(new Jugador("Julian"));
        jugadores.add(new Jugador("Mariana"));

        new JuegoDeLaSilla(1).jugar(jugadores);
    }

    public JuegoDeLaSilla(int tiempoMaximoPorRonda)
    {
        // cuando tiempo < 1 lanza error
        this.max = tiempoMaximoPorRonda;

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

    public void jugar(List<Jugador> jugadores) throws InterruptedException
    {
        // no se puede jugar con menos de dos jugadores
        if (jugadores.size() < 2) throw new IllegalStateException();

        this.jugadores = jugadores;

        inicializarSillas();

        while(jugadores.size() > 1)
        {

            int segundos = new Random().nextInt( (max - min) +1 ) + min;

            Thread.sleep(segundos * 1000);

            Jugador perdedor = nuevaVuelta();

            imprimir(++ronda, segundos, perdedor);

        }

        System.out.println("El ganador es " + jugadores.get(0).getNombre() + "!!!!");
    }

    // devuelve el jugador que perdio
    public Jugador nuevaVuelta()
    {
        for (Silla silla : sillas) {
            silla.sentarJugador(jugadores);
        }

        Jugador perdedor = null;

        for (Jugador jugador :jugadores) {
            if (!jugador.sentado())
            {

                perdedor = jugador;
            }
            else{
                jugador.levantarse();
            }
        }

        jugadores.remove(perdedor);

        // quitar silla
        Silla ultimaSilla = sillas.get(sillas.size() - 1);
        sillas.remove(ultimaSilla);
        return perdedor;
    }

    public void imprimir(int ronda, int segundos, Jugador jugador)
    {
        System.out.println("Ronda " + ronda +
                ": La música sonó "+segundos
                +" segundos y cuando paró la música perdió " +
                "\""+jugador.getNombre()+"\"");
    }
}
