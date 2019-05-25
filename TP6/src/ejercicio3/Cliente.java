package ejercicio3;

import java.util.LinkedList;
import java.util.List;

public abstract class Cliente
{
    private List<Cuenta> cuentas;
    private String residencia;

    public Cliente(String residencia)
    {
        this.residencia = residencia;
        this.cuentas = new LinkedList<>();
    }

    public abstract float costeTransaccion();

    public List<Cuenta> getCuentas()
    {
        return cuentas;
    }

    public Cuenta obtenerCuenta(int numeroCuenta)
    {
        for (Cuenta c: cuentas)
        {
            if ( c.getNumeroCuenta() == numeroCuenta )
            {
                return c;
            }
        }

        return null;
    }

    public void agregarCuenta(Cuenta cuenta)
    {
        // todo testear
        if (cuentas.contains(cuenta)) throw new IllegalStateException();

        cuenta.setCliente(this);
        this.cuentas.add(cuenta);
    }

    public String getResidencia() {
        return residencia;
    }
}
