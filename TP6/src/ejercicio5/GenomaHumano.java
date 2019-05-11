package ejercicio5;

public class GenomaHumano
{
    private static GenomaHumano genomaHumano = null;
    private Gen[] genes;
    private int cantidadGenes;

    private GenomaHumano()
    {
        this.cantidadGenes = 25000;
        int cantidadNucleotidos = (int)Math.random() * 5 + 5;

        genes = new Gen[cantidadGenes];

        for (int i = 0; i < cantidadGenes; i++)
        {
            // TODO: verificar upper y lower bound
            genes[i] = new Gen(i + 1, cantidadNucleotidos);
        }
    }

    // TODO: agregar lock
    public static GenomaHumano instancia()
    {
        if (genomaHumano == null)
        {
            genomaHumano = new GenomaHumano();
        }

        return genomaHumano;
    }

    public Gen[] genes()
    {
        return genes;
    }

    public int cantidadGenes()
    {
        return cantidadGenes;
    }
}
