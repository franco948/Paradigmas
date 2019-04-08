package ejercicio4;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FuncionZTest {

    @Test
    public void getValor() {
        // Arrange
        FuncionZ funcionZ = new FuncionZ();

        // Act
        int r1 = funcionZ.getValor(5, 4);
        int r2 = funcionZ.getValor(-6, 3);

        // Assert
        Assert.assertEquals(16, r1);
        Assert.assertEquals(5, r2);
    }
}