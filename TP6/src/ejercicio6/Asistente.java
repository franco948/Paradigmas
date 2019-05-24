package ejercicio6;

public abstract class Asistente
{
    private String nombre;
    private String apellido;
    private Congreso congreso;
    private String instituto;

    public Asistente(String nombre,String apellido, String instituto)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.instituto = instituto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public abstract float descuento();

    public void imprimirCredencial()
    {
        System.out.println("Congreso: " + congreso.getNombre());
        System.out.println("Nombre y Apellido: " + getNombre() + " " + getApellido());
        System.out.println("Instituto: " + getInstituto());
    }

    public void setCongreso(Congreso congreso) {
        this.congreso = congreso;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }
}
