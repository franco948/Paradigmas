package ejercicio6;

public class Presentador extends Asistente{
    public Presentador(String nombre, String apellido,String instituto) {
        super(nombre, apellido,instituto);
    }

    @Override
    public float descuento() {
        return 0.75f;
    }
}
