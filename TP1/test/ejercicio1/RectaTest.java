package ejercicio1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectaTest {

    @Test
    public void verificarPunto() {
        Recta recta = new Recta(7, 3);

        Assert.assertTrue(recta.verificarPunto(1,10));
        Assert.assertFalse(recta.verificarPunto(1,9));
    }
}