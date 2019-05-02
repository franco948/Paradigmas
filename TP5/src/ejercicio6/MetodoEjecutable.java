package ejercicio6;

import ejercicio7.Ejecutable;

public class MetodoEjecutable {

    public void metodo1() {
        throw new UnsupportedOperationException();
    }

    @Ejecutable
    public void metodo2() {
        System.out.println("MetodoEjecutable.metodo2");
    }
}
