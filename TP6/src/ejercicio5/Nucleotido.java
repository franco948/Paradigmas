package ejercicio5;

public class Nucleotido
{
    private TipoNucleotido valor;

    public Nucleotido(TipoNucleotido valor)
    {
        this.valor = valor;
    }

    public static Nucleotido crear()
    {
        // TODO: verificar upper y lower bound
        int random = (int)Math.random() * 3;

        TipoNucleotido valor = TipoNucleotido.values()[random];

        return new Nucleotido(valor);
    }
}
