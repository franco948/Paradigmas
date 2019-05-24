package ejercicio6;

public class Alumno extends  Asistente{

    private int año;

    public Alumno(String nombre, String apellido,String instituto, int año)
    {
        super(nombre,apellido,instituto);

        // todo agregar verificacion de anio
        this.año = año;
    }

    @Override
    public float descuento() {

        if (año >= 1 && año <= 3)
        {
            return 0.25f;
        }

        return 0;
    }
}
