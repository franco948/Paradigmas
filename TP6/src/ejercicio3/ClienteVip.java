package ejercicio3;

public class ClienteVip extends Cliente {
    public ClienteVip(String residencia) {
        super(residencia);
    }

    @Override
    public float costeTransaccion() {
        if (getResidencia().toLowerCase().equals("capital")){
            return 20;
        }

        return 0;
    }
}
