package ejercicio7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Ronda
{
    private Map<Silla, Jugador> historial = new HashMap<>();

    private Jugador perdedor;
    private int numeroRonda;
    private int duracion;

    // la duracion minima de la ronda debe ser de 1 segundo
    private int min = 1;

    public Ronda(int numeroRonda, List<Silla> sillas, List<Jugador> jugadores, int max)
    {
        this.numeroRonda = numeroRonda;
        int jugadoresSize = jugadores.size();
        int minSize = 0;

        int indice = new Random().nextInt( (jugadoresSize - minSize) + 0) + minSize;
        duracion = new Random().nextInt( (max - min) +1 ) + min;

        // TODO poner un Thread Sleep

        perdedor = jugadores.get(indice);
        jugadores.remove(indice);

        int i = 0;
        for (Jugador j : jugadores) {
            historial.put(sillas.get(i++), j);
        }

        sillas.remove(0);
    }

    public String imprimir()
    {
        return "Ronda " + numeroRonda +
                ": La música sonó "+duracion
                +" segundos y cuando paró la música perdió " +
                "\""+perdedor.getNombre()+"\"";
    }

    public Map<Silla, Jugador> getHistorial()
    {
        return historial;
    }

    public int getDuracion()
    {
        return duracion;
    }
}
