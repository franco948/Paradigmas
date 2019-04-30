package ejercicio5;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio5Test {

    @Test
    public void estaBalanceada_conCadenaVacia_devuelveTrue() {

        // ACT
        boolean r1 = Ejercicio5.estaBalanceada("");
        boolean r2 = Ejercicio5.estaBalanceada("   ");

        // ASSERT
        Assert.assertTrue(r1);
        Assert.assertTrue(r2);
    }

    @Test
    public void estaBalanceada_conExpresionInvalida_devuelveFalse() {

        String exp10 = "{{}";
        // ARRANGE
        String exp1 = "{ ( ( ) }";
        String exp2 = "  ()()() } ";

        // ACT
        boolean r1 = Ejercicio5.estaBalanceada(exp1);
        boolean r2 = Ejercicio5.estaBalanceada(exp2);

        boolean r3 = Ejercicio5.estaBalanceada(exp10);
        // ASSERT
        Assert.assertFalse(r1);
        Assert.assertFalse(r2);
        Assert.assertFalse(r3);
    }

    @Test
    public void estaBalanceada_conExpresionValida_devuelveTrue() {

        // ARRANGE
        String exp1 = " (( )({   })) ((( )[( )]))";

        // ACT
        boolean r1 = Ejercicio5.estaBalanceada(exp1);

        // ASSERT
        Assert.assertTrue(r1);
    }
}