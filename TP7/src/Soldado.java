

public class Soldado extends Entity implements ISoldado {

    //private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private IArma arma;

    public Soldado(String nombre, String apellido, int edad)
    {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        //setArma(new NullArma(this));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public IArma getArma() {
        return arma;
    }

    @Override
    public void setArma(IArma arma) {
        this.arma = arma;
    }
}
