package ejercicio3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio3Test {

    @Test
    public void encontrarCuatroDigitos() {

        // ACT
        int resultado = Ejercicio3.encontrarCuatroDigitos();

        // ASSERT
        System.out.println(resultado);
    }
}