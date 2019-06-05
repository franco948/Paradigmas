package ejercicio7;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class JuegoDeLaSilla
{
    private int max;
    private List<Jugador> jugadores;
    private List<Silla> sillas;
    private List<Ronda> rondas = new LinkedList<>();
    private Jugador ganador;

    public static void main(String[] args) throws InterruptedException
    {
        List<Jugador> jugadores = new LinkedList<>();
        jugadores.add(new Jugador("Dario"));
        jugadores.add(new Jugador("Hernan"));
        jugadores.add(new Jugador("Alejandro"));
        jugadores.add(new Jugador("Julian"));
        jugadores.add(new Jugador("Mariana"));

        JuegoDeLaSilla s = new JuegoDeLaSilla(jugadores,1);
        s.jugar();

        s.imprimir();
    }

    public JuegoDeLaSilla(List<Jugador> jugadores,int tiempoMaximoPorRonda)
    {
        this.jugadores = jugadores;
        inicializarSillas();
        // cuando tiempo < 1 lanza error
        this.max = tiempoMaximoPorRonda;
    }

    // devuelve el ganador
    public Jugador jugar()
    {
        if (jugadores.size() < 2) throw new IllegalStateException();

        int numeroRonda = 1;

        while (jugadores.size() > 1)
        {
            Ronda r = new Ronda(numeroRonda++, sillas,jugadores, max);
            rondas.add(r);
            r.imprimir();
        }

        ganador = jugadores.get(0);

        return ganador;
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

    public void imprimir()
    {
        for (Ronda r : rondas) {
            System.out.println(r.imprimir());
        }

        System.out.println("El ganador fue " + ganador.getNombre() + ". Felicidades!!!");
    }

    public List<Ronda> getRondas()
    {
        return rondas;
    }
}
