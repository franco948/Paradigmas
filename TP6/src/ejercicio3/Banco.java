package ejercicio3;

import java.util.LinkedList;
import java.util.List;

public class Banco {

    private List<Cliente> clientes;

    public Banco()
    {
        this.clientes = new LinkedList<>();

        // TODO: cargar clientes y sus cuentas
    }

    public void agregarCliente(Cliente cliente)
    {
        clientes.add(cliente);
    }

    public Cuenta obtenerCuenta(int numeroCuenta)
    {
        for (Cliente c : clientes)
        {
            Cuenta cuenta = c.obtenerCuenta(numeroCuenta);

            if (cuenta != null)
            {
                return cuenta;
            }
        }

        return null;
    }

    public float informeSaldo()
    {
        float total = 0;

        for (Cliente c : clientes)
        {
            for (Cuenta cuenta : c.getCuentas()) {
                total += cuenta.consultarSaldo();
            }
        }

        return total;
    }
}
