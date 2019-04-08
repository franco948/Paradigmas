package ejercicio3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactorialTest {

    @Test
    public void getValor() {
        // Arrange
        Factorial f0 = new Factorial(0);
        Factorial f1 = new Factorial(1);
        Factorial f2 = new Factorial(2);
        Factorial f3 = new Factorial(3);
        Factorial f4 = new Factorial(4);
        Factorial f5 = new Factorial(-5); // testea valor negativo

        // Act
        int v0 = f0.getValor();
        int v1 = f1.getValor();
        int v2 = f2.getValor();
        int v3 = f3.getValor();
        int v4 = f4.getValor();
        int v5 = f5.getValor();

        // Assert
        Assert.assertEquals(1, v0);
        Assert.assertEquals(1, v1);
        Assert.assertEquals(2, v2);
        Assert.assertEquals(6, v3);
        Assert.assertEquals(24, v4);
        Assert.assertEquals(120, v5);
    }
}