package ejercicio3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CajeroAutomaticoTest {

    private Cliente c1;
    private Cliente c2;
    private Cliente c3;
    private Cuenta cta1;
    private Cuenta cta2;
    private Cuenta cta3;
    private Cuenta cta4;
    private Banco banco;
    private CajeroAutomatico cajeroAutomatico;

    @Before
    public void setUp() throws Exception {
        c1 = new ClienteComun("Lugar1");
        cta1 = new Cuenta(1, 1000,1234);
        cta2 = new Cuenta(2, 2500,1234);
        c1.agregarCuenta(cta1);
        c1.agregarCuenta(cta2);


        c2 = new ClienteVip("Capital");
        cta3 = new Cuenta(3, 5000,1234);
        c2.agregarCuenta(cta3);

        c3 = new ClienteVip("Lugar2");
        cta4 = new Cuenta(4, 10000,1234);
        c3.agregarCuenta(cta4);

        banco = new Banco();
        banco.agregarCliente(c1);
        banco.agregarCliente(c2);
        banco.agregarCliente(c3);

        cajeroAutomatico = new CajeroAutomatico(banco);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void depositar_ClienteComun_Ok() {
        // ARRANGE
        float monto = 500;

        float saldoEsperado = monto + cta1.consultarSaldo() - 60;

        // ACT
        cajeroAutomatico.depositar(cta1.getNumeroCuenta(), monto);

        // ASSERT
        Assert.assertEquals(saldoEsperado, cta1.consultarSaldo(),0);
    }

    @Test
    public void depositar_ClienteVipViveEnCapital_Ok() {
        // ARRANGE
        float monto = 500;

        float saldoEsperado = monto + cta3.consultarSaldo() - 20;

        // ACT
        cajeroAutomatico.depositar(cta3.getNumeroCuenta(), monto);

        // ASSERT
        Assert.assertEquals(saldoEsperado, cta3.consultarSaldo(),0);
    }

    @Test
    public void depositar_ClienteVipNoViveEnCapital_Ok() {
        // ARRANGE
        float monto = 500;

        float saldoEsperado = monto + cta4.consultarSaldo();

        // ACT
        cajeroAutomatico.depositar(cta4.getNumeroCuenta(), monto);

        // ASSERT
        Assert.assertEquals(saldoEsperado, cta4.consultarSaldo(),0);
    }

    @Test
    public void extraer() {
        // ARRANGE
        int monto = 500;

        float saldoEsperado = cta1.consultarSaldo() - monto - 60;

        // ACT
        cajeroAutomatico.extraer(cta1.getNumeroCuenta(), monto);

        // ASSERT
        Assert.assertEquals(saldoEsperado, cta1.consultarSaldo(),0);
    }

    @Test
    public void consultarSaldo() {
        // ARRANGE
        float saldoEsperado = 1000;

        // ACT
        float saldoActual = cajeroAutomatico.consultarSaldo(cta1.getNumeroCuenta());

        // ASSERT
        Assert.assertEquals(saldoEsperado,saldoActual,0);
    }

    @Test
    public void cambiarPinHomeBanking() {
        // ARRANGE
        int viejoPin = 1234;
        int nuevoPin = 5005;

        // ACT
        cajeroAutomatico.cambiarPinHomeBanking(cta1.getNumeroCuenta(), viejoPin, nuevoPin);

        // ASSERT
        Assert.assertEquals(nuevoPin, cta1.getPin());
    }

    @Test
    public void informeSaldo() {
        // ARRANGE
        float saldoEsperado = cta1.consultarSaldo() + cta2.consultarSaldo() +
            cta3.consultarSaldo() + cta4.consultarSaldo();

        // ACT
        float saldoActual = banco.informeSaldo();


        // ASSERT
        Assert.assertEquals(saldoEsperado,saldoActual,0);
    }
}