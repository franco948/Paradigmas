package ejercicio3;

public class Cuenta
{
    private int numeroCuenta;
    private float saldo;
    private Cliente cliente;
    private int pin;

    public Cuenta(int numeroCuenta, float saldo, int pin)
    {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        //this.cliente = cliente;
        this.pin = pin;
    }

    public int getNumeroCuenta()
    {
        return numeroCuenta;
    }

    public void depositar(float monto)
    {
        if ( saldo + monto - cliente.costeTransaccion() < 0 )
        {
            throw new IllegalStateException();
        }
        else
        {
            saldo += monto - cliente.costeTransaccion();
        }
    }

    public void extraer(float monto)
    {
        float montoTotal = monto + cliente.costeTransaccion();

        if ( saldo - montoTotal < 0 )
        {
            throw new IllegalStateException();
        }
        else
        {
            saldo -= montoTotal;
        }
    }

    public float consultarSaldo()
    {
        return saldo;
    }

    public int getPin()
    {
        return pin;
    }

    public void cambiarPinHomeBanking(int pin, int nuevoPin)
    {
        if (this.pin == pin)
        {
            this.pin = nuevoPin;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
