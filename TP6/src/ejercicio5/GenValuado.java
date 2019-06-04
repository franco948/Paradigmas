package ejercicio5;

public class GenValuado {

    private Gen gen;
    private Nucleotido[] nucleotidos;

    public GenValuado(Gen gen)
    {
        this.gen = gen;
        nucleotidos = new Nucleotido[gen.getCantidadNucleotidos()];
    }

    public Nucleotido[] getNucleotidos() {
        return nucleotidos;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;

        if ( o.getClass() != this.getClass() ) return false;

        GenValuado gen = (GenValuado)o;

        if (this.gen.getId() != gen.gen.getId()) return false;

        if (this.gen.getCantidadNucleotidos() != ((GenValuado) o).gen.getCantidadNucleotidos()) return false;

        for (int i = 0; i < this.gen.getCantidadNucleotidos(); i++)
        {
            if ( nucleotidos[i] != gen.nucleotidos[i] ) return false;
        }

        return true;
    }
}
