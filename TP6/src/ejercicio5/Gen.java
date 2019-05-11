package ejercicio5;

public class Gen
{
    // TODO: usar fly weight
    private int id;
    private int cantidadNucleotidos;
    private Nucleotido[] nucleotidos;

    public Gen(int id, int cantidadNucleotidos)
    {
        this.id = id;
        this.cantidadNucleotidos = cantidadNucleotidos;
    }

    public Gen clonar()
    {
        Gen gen = new Gen(id, cantidadNucleotidos);
        gen.nucleotidos = new Nucleotido[cantidadNucleotidos];
        return gen;
    }

    public Nucleotido[] getNucleotidos()
    {
        return nucleotidos;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;

        if ( o.getClass() != this.getClass() ) return false;

        Gen gen = (Gen)o;

        if (this.id != gen.id) return false;

        if (this.cantidadNucleotidos != ((Gen) o).cantidadNucleotidos) return false;

        for (int i = 0; i < cantidadNucleotidos; i++)
        {
            if ( nucleotidos[i] != gen.nucleotidos[i] ) return false;
        }

        return true;
    }
}
