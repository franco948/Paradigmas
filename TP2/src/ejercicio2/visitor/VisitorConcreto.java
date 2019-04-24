package ejercicio2.visitor;

public class VisitorConcreto extends Visitor {

    @Override
    public Resultado VisitarPiedra(Elemento elemento) {
        if (elemento instanceof Piedra) {
            return Resultado.Empate;
        }
        else if (elemento instanceof Papel) {
            return Resultado.Derrota;
        }
        else if (elemento instanceof  Tijera) {
            return Resultado.Victoria;
        }
        else {
            throw new IllegalStateException();
        }
    }

    @Override
    public Resultado VisitarPapel(Elemento elemento) {
        if (elemento instanceof Piedra) {
            return Resultado.Victoria;
        }
        else if (elemento instanceof Papel) {
            return Resultado.Empate;
        }
        else if (elemento instanceof  Tijera) {
            return Resultado.Derrota;
        }
        else {
            throw new IllegalStateException();
        }
    }

    @Override
    public Resultado VisitarTijera(Elemento elemento) {
        if (elemento instanceof Piedra) {
            return Resultado.Derrota;
        }
        else if (elemento instanceof Papel) {
            return Resultado.Victoria;
        }
        else if (elemento instanceof  Tijera) {
            return Resultado.Empate;
        }
        else {
            throw new IllegalStateException();
        }
    }
}
