package ejercicio5;

import java.util.LinkedList;
import java.util.List;

public class Individuo
{
    private Gen[] genes;

    public Individuo()
    {
        int i = 0;
        int cantidadGenes = GenomaHumano.instancia().cantidadGenes();
        
        genes = new Gen[cantidadGenes];

        for (Gen g : GenomaHumano.instancia().genes())
        {
            Gen gen = g.clonar();

            Nucleotido[] nucleotidos = gen.getNucleotidos();

            for (int j = 0; j < nucleotidos.length; j++)
            {
                nucleotidos[j++] = Nucleotido.crear();
            }

            genes[i++] = gen;
        }
    }

    public List<Gen> genesIguales(Individuo otroIndividuo)
    {
        List<Gen> genesIguales = new LinkedList<>();

        for (int i = 0; i < genes.length; i++)
        {
            if (genes[i].equals(otroIndividuo.genes[i]))
            {
                genesIguales.add(genes[i]);
            }
        }

        return genesIguales;
    }
}
