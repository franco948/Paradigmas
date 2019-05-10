package ejercicio3;

public class CajeroAutomatico
{
    private Banco banco;

    public CajeroAutomatico(Banco banco)
    {
        this.banco = banco;
    }

    public void depositar(int numeroCuenta, float monto)
    {
        this.banco.obtenerCuenta(numeroCuenta).depositar(monto);
    }

    public void extraer(int numeroCuenta, float monto)
    {
        this.banco.obtenerCuenta(numeroCuenta).extraer(monto);
    }

    public float consultarSaldo(int numeroCuenta)
    {
        return this.banco.obtenerCuenta(numeroCuenta).consultarSaldo(numeroCuenta);
    }

    public void cambiarPinHomeBanking(int numeroCuenta, int pin, int nuevoPin)
    {
        this.banco.obtenerCuenta(numeroCuenta).cambiarPinHomeBanking(pin, nuevoPin);
    }
}
