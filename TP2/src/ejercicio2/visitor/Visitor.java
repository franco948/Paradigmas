package ejercicio2.visitor;

public abstract class Visitor {
    public abstract Resultado VisitarPiedra(Elemento elemento);
    public abstract Resultado VisitarPapel(Elemento elemento);
    public abstract Resultado VisitarTijera(Elemento elemento);
}
