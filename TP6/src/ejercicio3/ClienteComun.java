package ejercicio3;

public class ClienteComun extends Cliente {
    public ClienteComun(String residencia) {
        super(residencia);
    }

    @Override
    public float costeTransaccion() {
        return 60;
    }
}
