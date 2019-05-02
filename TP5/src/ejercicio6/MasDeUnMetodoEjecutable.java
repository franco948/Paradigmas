package ejercicio6;

import ejercicio7.Ejecutable;

public class MasDeUnMetodoEjecutable {

    @Ejecutable
    public void metodo1() {
        throw new UnsupportedOperationException();
    }

    @Ejecutable
    public void metodo2() {
        throw new UnsupportedOperationException();
    }
}
