package ejercicio2.visitor;

public class Papel extends Elemento {

    @Override
    public Resultado Aceptar(Visitor visitor, Elemento elemento) {
        return visitor.VisitarPapel(elemento);
    }
}
