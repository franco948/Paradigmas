package ejercicio6;

public class Particular  extends Asistente{

    private String  domicilio;

    public Particular(String nombre, String apellido, String instituto,String domicilio) {
        super(nombre, apellido,instituto);
        this.domicilio = domicilio;
    }

    @Override
    public float descuento() {
        if(!domicilio.equals("Buenos Aires"))
        {
            return 0.1f;
        }

        return 0;
    }
}
