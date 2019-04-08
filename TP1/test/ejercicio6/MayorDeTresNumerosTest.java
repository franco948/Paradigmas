package ejercicio6;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MayorDeTresNumerosTest {

    @Test
    public void escribirDeMenorAMayor() {
        // Arrange
        MayorDeTresNumeros m = new MayorDeTresNumeros();

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        m.escribirDeMenorAMayor(52.45f, 52.453f, 52.45302f);

        // Assert

        Assert.assertEquals("52,4500 52,4530 52,4530\n", outContent.toString());
    }
}