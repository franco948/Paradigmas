package ejercicio2.visitor;

public abstract class Elemento {
    public abstract Resultado Aceptar(Visitor visitor, Elemento elemento);
}
