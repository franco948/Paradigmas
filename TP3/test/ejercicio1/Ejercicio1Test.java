package ejercicio1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ejercicio1Test {

    @Test
    public void calcular() {
        // ARRANGE
        String exp1 = "10 + 45";
        String exp2 = "20 - 30";
        String exp3 = "4 * 5";
        String exp4 = "15 / -3";

        // ACT
        double result1 = Ejercicio1.calcular(exp1);
        double result2 = Ejercicio1.calcular(exp2);
        double result3 = Ejercicio1.calcular(exp3);
        double result4 = Ejercicio1.calcular(exp4);

        // ASSERT
        Assert.assertEquals(10 + 45, result1, 0);
        Assert.assertEquals(20 - 30, result2, 0);
        Assert.assertEquals(4 * 5, result3, 0);
        Assert.assertEquals(15 / -3, result4, 0);
    }
}