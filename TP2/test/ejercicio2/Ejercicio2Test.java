package ejercicio2;

import ejercicio2.visitor.Resultado;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.transform.Result;

import static org.junit.Assert.*;

public class Ejercicio2Test {

    @Test(expected = IllegalStateException.class)
    public void jugar_JugadorUnoInvalido_LanzaError() {
        // ACT
        Ejercicio2.jugar(Ejercicio2.PIEDRA + " ", Ejercicio2.PIEDRA);
    }

    @Test(expected = IllegalStateException.class)
    public void jugar_JugadorDosInvalido_LanzaError() {
        // ACT
        Ejercicio2.jugar(Ejercicio2.PIEDRA, Ejercicio2.PIEDRA + " ");
    }

    @Test
    public void jugar_Piedra_Ok() {
        // ACT
        Resultado resultado1 = Ejercicio2.jugar(Ejercicio2.PIEDRA, Ejercicio2.PIEDRA);
        Resultado resultado2 = Ejercicio2.jugar(Ejercicio2.PIEDRA, Ejercicio2.PAPEL);
        Resultado resultado3 = Ejercicio2.jugar(Ejercicio2.PIEDRA, Ejercicio2.TIJERA);

        // ASSERT
        Assert.assertEquals(Resultado.Empate, resultado1);
        Assert.assertEquals(Resultado.Derrota, resultado2);
        Assert.assertEquals(Resultado.Victoria, resultado3);
    }

    @Test
    public void jugar_Papel_Ok() {
        // ACT
        Resultado resultado1 = Ejercicio2.jugar(Ejercicio2.PAPEL, Ejercicio2.PIEDRA);
        Resultado resultado2 = Ejercicio2.jugar(Ejercicio2.PAPEL, Ejercicio2.PAPEL);
        Resultado resultado3 = Ejercicio2.jugar(Ejercicio2.PAPEL, Ejercicio2.TIJERA);

        // ASSERT
        Assert.assertEquals(Resultado.Victoria, resultado1);
        Assert.assertEquals(Resultado.Empate, resultado2);
        Assert.assertEquals(Resultado.Derrota, resultado3);
    }

    @Test
    public void jugar_Tijera_Ok() {
        // ACT
        Resultado resultado1 = Ejercicio2.jugar(Ejercicio2.TIJERA, Ejercicio2.PIEDRA);
        Resultado resultado2 = Ejercicio2.jugar(Ejercicio2.TIJERA, Ejercicio2.PAPEL);
        Resultado resultado3 = Ejercicio2.jugar(Ejercicio2.TIJERA, Ejercicio2.TIJERA);

        // ASSERT
        Assert.assertEquals(Resultado.Derrota, resultado1);
        Assert.assertEquals(Resultado.Victoria, resultado2);
        Assert.assertEquals(Resultado.Empate, resultado3);
    }
}