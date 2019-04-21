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
}