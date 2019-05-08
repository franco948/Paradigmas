package ejercicio2;

import java.util.ArrayList;

public class Pila
{
    int capacidadMaxima;
    private ArrayList<Character> caracteres = new ArrayList<>();

    public Pila()
    {
        capacidadMaxima = 0;
    }

    public Pila(int capacidadMaxima)
    {
        if (capacidadMaxima < 1)
        {
            throw new IllegalStateException();
        }

        this.capacidadMaxima = capacidadMaxima;
    }

    public void push(Character caracter)
    {
        if (capacidadMaxima == 0)
        {
            caracteres.add(caracter);
        }
        else
        {
            if (caracteres.size() < capacidadMaxima)
            {
                caracteres.add(caracter);
            }
            else
            {
                throw new IndexOutOfBoundsException();
            }
        }
    }

    public Character pop()
    {
        if (caracteres.size() == 0)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            int index = caracteres.size() - 1;
            Character c = caracteres.get(index);
            caracteres.remove(index);
            return c;
        }
    }

    public int length()
    {
        return caracteres.size();
    }

    public boolean isEmpty()
    {
        return caracteres.isEmpty();
    }
}
