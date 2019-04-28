package ejercicio3;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VerificadoraTest {

    @Test
    public void validarEmail_EmailsValidos_DevuelveTrue() {
        // ARRANGE
        String[] emails = new String[] {
                "hernan94@gmail.com.ar",
                "lautaroF@hotmail.com.es",
                "gomez94mariano@yahoo.com.AR"
        };

        // ACT - ASSERT
        for (int i = 0; i < emails.length; i++) {
            Assert.assertTrue(Verificadora.validarEmail(emails[i]));
        }
    }

    @Test
    public void validarEmail_EmailsNoValidos_DevuelveFalse() {
        // ARRANGE
        String[] emails = new String[] {
                "hernan94@gmail.com.",
                "lautaroF?@hotmail.com.es",
                "gomez94 mariano@yahoo.com.AR",
                "martin@yahoo.com..ar"
        };

        // ACT - ASSERT
        for (int i = 0; i < emails.length; i++) {
            Assert.assertFalse(Verificadora.validarEmail(emails[i]));
        }
    }

    @Test
    public void validarFecha_ConFechasValidas_DevuelveTrue() {
        // ARRANGE
        String[] fechas = {
                "9/12/2014",
                "12/9/2000",
                "04/11/1994"
        };

        // ACT - ASSERT
        for (int i = 0; i < fechas.length; i++) {
            System.out.println(fechas[i]);
            Assert.assertTrue(Verificadora.validarFecha(fechas[i]));
        }
    }

    @Test
    public void validarFecha_ConFechasNoValidas_DevuelveFalse() {
        // ARRANGE
        String[] fechas = {
                "9/14/2014",
                "012/9/2000",
                "04/11/194",
                "12/5",
                "12/5/19956",
                "32/5/1995"
        };

        // ACT - ASSERT
        for (int i = 0; i < fechas.length; i++) {
            System.out.println(fechas[i]);
            Assert.assertFalse(Verificadora.validarFecha(fechas[i]));
        }
    }
}