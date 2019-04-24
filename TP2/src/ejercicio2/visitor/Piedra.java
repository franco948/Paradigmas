package ejercicio2.visitor;

public class Piedra extends Elemento {

    @Override
    public Resultado Aceptar(Visitor visitor, Elemento elemento) {
        return visitor.VisitarPiedra(elemento);
    }
}
