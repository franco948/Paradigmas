package ejercicio4;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class Ejercicio4Test {

    /* Teastea numeros enteros positivos primos */
    @Test
    public void esPrimo_PrimoPositivo_DevuelveTrue() {
        // Arrange

        // Act
        boolean r1 = Ejercicio4.esPrimo(1);
        boolean r2 = Ejercicio4.esPrimo(2);
        boolean r3 = Ejercicio4.esPrimo(3);
        boolean r4 = Ejercicio4.esPrimo(5);
        boolean r5 = Ejercicio4.esPrimo(7);
        boolean r6 = Ejercicio4.esPrimo(11);

        // Assert
        Assert.assertTrue(r1);
        Assert.assertTrue(r2);
        Assert.assertTrue(r3);
        Assert.assertTrue(r4);
        Assert.assertTrue(r5);
        Assert.assertTrue(r6);
    }

    /* Teastea numeros enteros negativos primos */
    @Test
    public void esPrimo_PrimoNegativo_DevuelveTrue() {
        // Arrange

        // Act
        boolean r1 = Ejercicio4.esPrimo(-1);
        boolean r2 = Ejercicio4.esPrimo(-2);
        boolean r3 = Ejercicio4.esPrimo(-3);
        boolean r4 = Ejercicio4.esPrimo(-5);
        boolean r5 = Ejercicio4.esPrimo(-7);
        boolean r6 = Ejercicio4.esPrimo(-11);

        // Assert
        Assert.assertTrue(r1);
        Assert.assertTrue(r2);
        Assert.assertTrue(r3);
        Assert.assertTrue(r4);
        Assert.assertTrue(r5);
        Assert.assertTrue(r6);
    }

    /* Teastea numeros enteros positivos NO primos */
    @Test
    public void esPrimo_NoPrimoPositivo_DevuelveFalse() {
        // Arrange

        // Act
        boolean r1 = Ejercicio4.esPrimo(4);
        boolean r2 = Ejercicio4.esPrimo(6);
        boolean r3 = Ejercicio4.esPrimo(8);
        boolean r4 = Ejercicio4.esPrimo(9);
        boolean r5 = Ejercicio4.esPrimo(10);
        boolean r6 = Ejercicio4.esPrimo(12);

        // Assert
        Assert.assertFalse(r1);
        Assert.assertFalse(r2);
        Assert.assertFalse(r3);
        Assert.assertFalse(r4);
        Assert.assertFalse(r5);
        Assert.assertFalse(r6);
    }

    /* Teastea numeros enteros positivos NO primos */
    @Test
    public void esPrimo_NoPrimoNegativo_DevuelveFalse() {
        // Arrange

        // Act
        boolean r1 = Ejercicio4.esPrimo(-4);
        boolean r2 = Ejercicio4.esPrimo(-6);
        boolean r3 = Ejercicio4.esPrimo(-8);
        boolean r4 = Ejercicio4.esPrimo(-9);
        boolean r5 = Ejercicio4.esPrimo(-10);
        boolean r6 = Ejercicio4.esPrimo(-12);

        // Assert
        Assert.assertFalse(r1);
        Assert.assertFalse(r2);
        Assert.assertFalse(r3);
        Assert.assertFalse(r4);
        Assert.assertFalse(r5);
        Assert.assertFalse(r6);
    }

    @Test
    public void guardarEnArchivo_NumerosPrimos_Ok() throws IOException {
        // Arrange
        String path = "primosTest.txt";

        FileWriter fileWriter = new FileWriter(path);

        String output = 1 + System.lineSeparator() +
                        2 + System.lineSeparator() +
                        3 + System.lineSeparator() +
                        5 + System.lineSeparator() +
                        7 + System.lineSeparator();

        fileWriter.write(output);

        fileWriter.flush();
        fileWriter.close();

        // Act
        Ejercicio4.guardarEnArchivo(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});

        // Assert
        int i = 0;

        String[] expectedNumbers = new String[] {"1", "2", "3", "5", "7"};

        Scanner scanner = new Scanner(new File(path));

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            // process the line
            Assert.assertEquals(expectedNumbers[i++], line);
        }

        // verifica que se hayan leido todas las lineas
        Assert.assertEquals(expectedNumbers.length, i);
    }

    @Test
    public void guardarEnArchivo_DivisoresDe3Mil_Ok() throws IOException {
        // Arrange
        String path = "divisores_de_3000_test.txt";

        FileWriter fileWriter = new FileWriter(path);

        String output = 1 + System.lineSeparator() +
                2 + System.lineSeparator() +
                3 + System.lineSeparator() +
                4 + System.lineSeparator() +
                5 + System.lineSeparator() +
                6 + System.lineSeparator() +
                8 + System.lineSeparator();

        fileWriter.write(output);

        fileWriter.flush();
        fileWriter.close();

        // Act
        Ejercicio4.guardarEnArchivo(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 13});

        // Assert
        int i = 0;

        String[] expectedNumbers = new String[] {"1", "2", "3", "4", "5", "6", "8"};

        Scanner scanner = new Scanner(new File(path));

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            // process the line
            Assert.assertEquals(expectedNumbers[i++], line);
        }

        // verifica que se hayan leido todas las lineas
        Assert.assertEquals(expectedNumbers.length, i);
    }

    @Test
    public void guardarEnArchivo_PromedioDeImparesYPares_Ok() throws IOException {
        // Arrange
        String path = "promedios_test.txt";

        FileWriter fileWriter = new FileWriter(path);

        String output = 5 + System.lineSeparator() +
                        5 + System.lineSeparator();

        fileWriter.write(output);

        fileWriter.flush();
        fileWriter.close();

        // Act
        Ejercicio4.guardarEnArchivo(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});

        // Assert
        int i = 0;

        String[] expectedNumbers = new String[] {"5", "5"};

        Scanner scanner = new Scanner(new File(path));

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            // process the line
            Assert.assertEquals(expectedNumbers[i++], line);
        }

        // verifica que se hayan leido todas las lineas
        Assert.assertEquals(expectedNumbers.length, i);
    }
}