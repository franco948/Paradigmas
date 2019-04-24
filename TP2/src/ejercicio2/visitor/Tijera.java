package ejercicio2.visitor;

public class Tijera extends Elemento {

    @Override
    public Resultado Aceptar(Visitor visitor, Elemento elemento) {
        return visitor.VisitarTijera(elemento);
    }
}
