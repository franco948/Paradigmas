package ejercicio5;

import java.util.LinkedList;
import java.util.List;

public class Individuo
{
    private GenValuado[] genes;

    public Individuo()
    {
        int i = 0;
        int cantidadGenes = GenomaHumano.instancia().cantidadGenes();
        
        genes = new GenValuado[cantidadGenes];

        for (Gen g : GenomaHumano.instancia().genes())
        {
            GenValuado gen = new GenValuado(g);

            Nucleotido[] nucleotidos = gen.getNucleotidos();

            for (int j = 0; j < nucleotidos.length; j++)
            {
                nucleotidos[j++] = Nucleotido.crear();
            }

            genes[i++] = gen;
        }
    }

    public List<GenValuado> genesIguales(Individuo otroIndividuo)
    {
        List<GenValuado> genesIguales = new LinkedList<>();

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
