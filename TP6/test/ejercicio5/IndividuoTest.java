package ejercicio5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IndividuoTest
{
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void genesIguales()
    {
        // ARRANGE
        Individuo individuo = new Individuo();
        // Individuo otroIndividuo = new Individuo();

        int expectedSize = 25000;

        // ACT
        List<Gen> genesIguales = individuo.genesIguales(individuo);

        // ASSERT
        Assert.assertEquals(expectedSize, genesIguales.size());
    }
}