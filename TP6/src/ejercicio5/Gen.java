package ejercicio5;

public class Gen
{
    // TODO: usar fly weight
    private int id;
    private int cantidadNucleotidos;

    public Gen(int id, int cantidadNucleotidos)
    {
        this.id = id;
        this.cantidadNucleotidos = cantidadNucleotidos;
    }

    public int getId() {
        return id;
    }

    public int getCantidadNucleotidos() {
        return cantidadNucleotidos;
    }

   /* public Gen clonar()
    {
        Gen gen = new GenValuado(id, cantidadNucleotidos);
        gen.nucleotidos = new Nucleotido[cantidadNucleotidos];
        return gen;
    }*/

/*    public Nucleotido[] getNucleotidos()
    {
        return nucleotidos;
    }*/

}
